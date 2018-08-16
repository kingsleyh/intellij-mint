component A {
  fun a : String {
    "test"
  }

  fun b : String {
    a()
  }

  fun render : Html {
    <div/>
  }
}