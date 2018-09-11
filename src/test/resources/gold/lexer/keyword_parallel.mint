component Cool {

  fun render : Html {
    </div>
  }

  fun go() : Void {
    parallel {
      something()
    } then {
      something()
    }
  }

}