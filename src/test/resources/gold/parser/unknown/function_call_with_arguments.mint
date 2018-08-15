module FunctionCall {
  fun test (a : String, b : Bool) : Bool {
    b
  }

  fun call : Bool {
    test("Hello", true)
  }
}