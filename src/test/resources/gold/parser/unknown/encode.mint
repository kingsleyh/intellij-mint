record Test {
  name : String,
  age : Number
}

module Test {
  fun encode : Object {
    encode { name = "Hello", age = 20 }
  }
}