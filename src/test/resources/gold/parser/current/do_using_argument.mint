component Do {
  state greeting : String = "ho"

  fun test : Void {
    do {
      greeting = "hello"
      next { greeting = greeting }
    }
  }

  fun render : Html {
    <div/>
  }
}