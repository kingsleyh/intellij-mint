module Test {
  fun a (value : String) : String {
    value
  }

  fun b : String {
    Test.a("Lorem ipsum dolor sit amet")
  }
}