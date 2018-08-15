record MouseProvider.Data {
  moves : Function(Position, Void),
  ups : Function(Position, Void)
}

provider MouseProvider : MouseProvider.Data {
  fun attach : Void {
    void
  }
}

component Test {
  use MouseProvider {
    moves = (data : Position) : Void => { void },
    ups = (data : Position) : Void => { void }
  } when {
    false
  }

  fun componentWillUnmount : Void {
    void
  }

  fun componentDidUpdate : Void {
    void
  }

  fun componentDidMount : Void {
    void
  }

  fun render : Html {
    <div/>
  }
}