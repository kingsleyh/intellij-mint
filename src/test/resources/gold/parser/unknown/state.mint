component Test {
  state a : String = "Hello"
  state b : String = "0"

  fun x : String {
    a + b
  }

  fun render : Html {
    <div/>
  }
}
