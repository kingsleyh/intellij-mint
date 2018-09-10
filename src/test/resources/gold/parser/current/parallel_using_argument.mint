component Do {
  state greeting : String = "ho"

  fun test : Void {
    parallel {
      greeting = "hello"
      next { greeting = greeting }
    }
  }

  fun render : Html {
    <div/>
  }
}