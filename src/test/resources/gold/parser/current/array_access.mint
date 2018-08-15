module Test {
  fun test : Maybe(String) {
    [
      "Hello",
      "Blah",
      "Joe"
    ][1]
  }

  fun test1 : Maybe(a) {
    [][1]
  }
}