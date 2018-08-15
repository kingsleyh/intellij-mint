module Result {
  fun error (input : a) : Result(a, b) {
    `new Err(input)`
  }
}

module A {
  fun test : String {
    try {
      x =
        Result.error("Blah")

      x
    } catch String => error {
      error
    }
  }
}