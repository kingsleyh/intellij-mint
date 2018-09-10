component Do {
  fun test : Void {
    parallel {
      greeting = "hello"
      void
    }
  }

  fun render : Html {
    <div/>
  }
}