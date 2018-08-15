record X {
  name : String
}

component A {
  fun a : String {
    x.name
  } where {
    x = { name = "test" }
  }

  fun render : Html {
    <div/>
  }
}