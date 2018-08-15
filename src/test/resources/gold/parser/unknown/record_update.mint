record Record {
  name: String
}

component RecordUpdate {
  property record : Record = { name = "Doe" }

  fun test : Record {
    { record | name = "John" }
  }

  fun render : Html {
    <div/>
  }
}