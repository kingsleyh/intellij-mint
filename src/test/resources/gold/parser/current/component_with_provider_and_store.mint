record MouseProvider.Data {
  moves : Function(Position, Void),
  ups : Function(Position, Void)
}

provider MouseProvider : MouseProvider.Data {
  fun attach : Void {
    void
  }
}

store Blah {
  state test : String = ""

  fun x : String {
    "hello"
  }
}

component Test {
  use MouseProvider {
    moves = (data : Position) : Void => { void },
    ups = (data : Position) : Void => { void }
  } when {
    false
  }

  connect Blah exposing { test, x }

  fun render : Html {
    <div/>
  }
}