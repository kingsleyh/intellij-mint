component A {
  style test {
    & div {
      color: {color};
    }
    &:focus {
      color: red;
    }
  }

  get color : String {
    "blue"
  }

  fun render : Html {
    <div::test/>
  }
}