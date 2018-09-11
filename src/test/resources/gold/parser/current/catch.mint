module Promise {
  fun reject (input : a) : Promise(a, b) {
    ``
  }
}

component Do {
  fun test : Void {
    parallel {
      greeting =
        Promise.reject("hello")

      void
    } catch String => a {
      void
    } catch {
      "Catching all errors here"
    }
  }

  fun render : Html {
    <div/>
  }
}