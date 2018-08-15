routes {

  /home {
    do {
      Application.setPage("home")
    }
  }

  / {
    do {
      Application.setPage("home")
    }
  }

   * {
     Application.setPage("not_found")
   }

}