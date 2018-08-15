module A {

  fun a() : String {
    woop()
  } catch Error.Message => error {
    error()
  }

}