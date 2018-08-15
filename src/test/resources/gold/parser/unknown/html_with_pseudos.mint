component HtmlStyle {
  property hoverBackground : String = "yellow"
  property background : String = "blue"

  style test {
    background: {background};
    color: red;

    &:hover {
      background: {hoverBackground};
      color: cyan;
    }

    & div {
      font-family: {"Hello"};
      color: blue;
    }
  }

  fun render : Html {
    <div::test>
    </div>
  }
}