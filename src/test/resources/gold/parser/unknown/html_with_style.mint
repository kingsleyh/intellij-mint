component HtmlStyle {
  property background : String = "blue"

  style test {
    background: {background};
    color: red;
  }

  fun render : Html {
    <div::test>
    </div>
  }
}