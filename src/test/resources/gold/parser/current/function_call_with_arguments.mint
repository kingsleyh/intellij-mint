module FunctionCall {
  fun tester (a : String, b : Bool) : Bool {
    b
  }

  fun call : Bool {
    tester("Hello", true)
  }
}