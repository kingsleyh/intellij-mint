routes {
  /calibration {
    sequence {
      Application.setPage("calibration")
    }
  }

  /calibration/run {
    sequence {
      Application.setPage("calibration-run")
    }
  }

  /calibration/feedback {
    sequence {
      Application.setPage("calibration-feedback")
    }
  }

  /coach {
    sequence {
      Application.setPage("coach")
    }
  }

 /coach/new/:id (id: Number){
    sequence {
      Application.setPage("coach")
    }
  }

 /coach/id/:id/name/:age (id: Number, age: Number){
    sequence {
      Application.setPage("coach")
    }
  }

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
