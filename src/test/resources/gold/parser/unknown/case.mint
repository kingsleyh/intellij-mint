component Case {
  fun test : Bool {
    case ("Hello") {
      "test" => true
      "Hello" => false
      => false
    }
  }

  fun render : Html {
    <div/>
  }
}