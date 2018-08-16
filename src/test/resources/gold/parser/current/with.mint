module X {
  fun a : Void {
    void
  }
}

module Test {
  fun test : Void {
    with X {
      a()
    }
  }
}