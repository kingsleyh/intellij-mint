record X.Y {
  blah : String
}

record X {
  name : String,
  y: X.Y
}

component A {
  fun x (input : Object) : Result(Object.Error, x) {
    decode input as X
  }

  fun render : Html {
    <div/>
  }
}