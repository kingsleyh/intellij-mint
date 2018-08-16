module A {
  fun test : String {
    a("Joe")
  } where {
    a =
      (b : String) : String => { b }
  }
}