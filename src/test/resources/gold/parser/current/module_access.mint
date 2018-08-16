module Test {
  fun a : String {
    "Hello"
  }

  fun b : Function(String) {
    Test.a
  }
}