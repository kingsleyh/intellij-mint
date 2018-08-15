component A {
  style test {
    margin: {margin}px 0px;
  }

  get margin : Number {
    10
  }

  fun render : Html {
    <div::test/>
  }
}