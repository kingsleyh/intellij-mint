component Test {
  state name : String = "Joe"
  state age : Number = 24

  fun test : Void {
    next
      {
        name = "Hello",
        age = 30
      }
  }

  fun render : Html {
    <div/>
  }
}