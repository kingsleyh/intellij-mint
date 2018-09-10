module Promise {
  fun reject (input : a) : Promise(a, b) {
    ``
  }
}

component Do {
  fun test : Void {
    sequence {
      greeting =
        Promise.reject("hello")

      void
    } catch String => a {
      "hello"
    }
  }

  fun render : Html {
    <div/>
  }
}