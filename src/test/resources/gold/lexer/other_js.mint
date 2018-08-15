module Js {

  fun generateNewWallet (networkPrefix : String) : Result(Wallet.Error, Wallet) {
      `
      (() => {
        try {
          if (["T0", "M0"].indexOf(networkPrefix) === -1) {
            return new Err($Wallet_Error_InvalidNetwork)
          }

          var keyPair = generateValidKeyPair();

          var wallet = {
            publicKey: keyPair.hexPublicKey,
            wif: makeWif(keyPair.hexPrivateKey, networkPrefix),
            address: makeAddress(keyPair.hexPublicKey, networkPrefix)
          }

          return new Ok(new Record(wallet))
        } catch (e) {
          return new Err($Wallet_Error_WalletGenerationError)
        }
      })()
      `
    }

    fun encryptWallet (wallet : Wallet, password : String) : Result(Wallet.Error, EncryptedWallet) {
      `
      (() => {
        try {
          var address = wallet.address;
          var salt = all_crypto.bcrypt.genSaltSync(10)
          var hash = all_crypto.bcrypt.hashSync(password, salt)

          var walletJson = JSON.stringify(wallet);
          var bf = new all_crypto.blowfish(reverseString(hash));
          var ciphertext = ab2hexstring(bf.encode(walletJson));

          var encryptedWallet = {
                 source: "kajiki",
                 ciphertext: ciphertext,
                 address: address,
                 salt: salt
          };

          return new Ok(new Record(encryptedWallet))
        } catch (e) {
          return new Err($Wallet_Error_EncryptWalletError)
        }
      })()
      `
    }

    fun decryptWallet (encryptedWallet : EncryptedWallet, password : String) : Result(Wallet.Error, Wallet) {
      `
      (() => {
        try {
          var hash = all_crypto.bcrypt.hashSync(password, encryptedWallet.salt)
          var bf = new all_crypto.blowfish(reverseString(hash));
          var binaryCipherText = new Uint8Array(hexstring2ab(encryptedWallet.ciphertext));
          var wallet = JSON.parse(bf.decode(binaryCipherText));

          return new Ok(new Record(wallet))
        } catch (e) {
          return new Err($Wallet_Error_DecryptWalletError)
        }
      })()
      `
    }


}