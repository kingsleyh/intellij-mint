enum Cars {
  Mercedes
  Volvo
  BMW
}

component A {

  state error : String = ""
  property name : String = ""

  fun js() : Thing {
    `var name = 'cool' ; return name;`
  }

  fun a() : Void {
    sequence {
      if(a == 1 && b != 2 || c <= 3 || c > a && b < x || b >= y){
        true
      } else {
        false
      }

      a = !true

      b = 1 + 1 - 4 * 8 / 6 % 2

      c = Cars::Volvo

      someList
      |> Array.map(getName)
      |> Array.filter((n : String) : String => { n + "_hello"})

    } catch Error => error {
      void
    } catch String => error {
      next { error = error}
    }

  } where {
    myList
  }

}
