component A {
  fun a : String {
    "Hello"
  }

  fun b : Function(String) {
    a
  }

  fun render : Html {
    <div/>
  }
}