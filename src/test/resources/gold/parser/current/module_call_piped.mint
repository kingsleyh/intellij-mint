module Test {
  fun a (value : String, x : Bool) : String {
    value
  }

  fun b : String {
    true
    |> Test.a("Lorem ipsum dolor sit amet")
  }
}