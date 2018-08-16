record Record {
  name: String
}

component RecordUpdate {
  property recordx : Record = { name = "Doe" }

  fun test : Record {
    { recordx | name = "John" }
  }

  fun render : Html {
    <div/>
  }
}