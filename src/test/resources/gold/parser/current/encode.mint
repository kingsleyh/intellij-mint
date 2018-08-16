record Test {
  name : String,
  age : Number
}

module Test {
  fun encoder : Object {
    encode { name = "Hello", age = 20 }
  }
}