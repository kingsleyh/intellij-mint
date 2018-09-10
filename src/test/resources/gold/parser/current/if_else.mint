component IfElse {
  fun test : Bool {
    if ("asd" == "asd2") {
      true
    } else if (1 == 2) {
      false
    } else if (3 == 5) {
      false
    } else {
      true
    }
  }

  fun render : Html {
    <div/>
  }
}