component Do {
  state greeting : String = "ho"

  fun test : Void {
    sequence {
      greeting = "hello"
      next { greeting = greeting }
    }
  }

  fun render : Html {
    <div/>
  }
}