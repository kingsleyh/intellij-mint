routes {
  /calibration {
    do {
      Application.setPage("calibration")
    }
  }

  /calibration/run {
    do {
      Application.setPage("calibration-run")
    }
  }

  /calibration/feedback {
    do {
      Application.setPage("calibration-feedback")
    }
  }

  /coach {
    do {
      Application.setPage("coach")
    }
  }

 /coach/new/:id (id: Number){
    do {
      Application.setPage("coach")
    }
  }

 /coach/id/:id/name/:age (id: Number, age: Number){
    do {
      Application.setPage("coach")
    }
  }

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
