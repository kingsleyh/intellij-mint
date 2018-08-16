module A {
  fun test : String {
    a()
  } where {
    a = () : String => { "Hello" }
  }
}