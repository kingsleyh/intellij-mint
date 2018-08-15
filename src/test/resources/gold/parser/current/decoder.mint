record Y  {
  size : Number using "SIIIZEEE"
}

record X {
  string : String,
  number : Number,
  bool : Bool,
  time : Time,
  maybe : Maybe(String),
  array : Array(String),
  y : Y
}

component A {
  fun x (input : Object) : Result(Object.Error, x) {
    decode input as X
  }

  fun render : Html {
    <div/>
  }
}