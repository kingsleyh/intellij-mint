component Do {
  fun test : Void {
    sequence {
      greeting = "hello"
      void
    }
  }

  fun render : Html {
    <div/>
  }
}