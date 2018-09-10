routes {

  /home {
    sequence {
      Application.setPage("home")
    }
  }

  / {
    sequence {
      Application.setPage("home")
    }
  }

   * {
     Application.setPage("not_found")
   }

}