suite "Array foldl" {
  test "folds left" {
    Array.Extra.foldl(
      (acc : Number, n : Number) : Number => { acc + n },
      0,
      [
        1,
        2,
        3,
        4,
        5
      ]) == 15
  }
}