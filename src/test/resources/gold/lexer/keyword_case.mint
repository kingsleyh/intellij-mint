module CoachGenerator {

  fun generate (days : Number, workoutHistory : Array(WorkoutsResult), calibrationResult : CalibrationResult) : Array(Workouts) {
    case (days) {
      1 => generate1(workoutHistory, calibrationResult)
      2 => generate2(workoutHistory, calibrationResult)
      3 => generate3(workoutHistory, calibrationResult)
      4 => generate4(workoutHistory, calibrationResult)
      5 => generate5(workoutHistory, calibrationResult)
      6 => generate6(workoutHistory, calibrationResult)
      7 => generate7(workoutHistory, calibrationResult)
      => generate3(workoutHistory, calibrationResult)
    }
  }

}