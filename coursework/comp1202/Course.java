
class Course {
  private Subject subject; // subject associated with the course
  private Integer daysUntilStarts; // number of days until the course starts
  private Integer daysToRun; // number of remaining days the course still has to run
  
  // Course constructor
  public Course(Subject subject, Integer daysUntilStarts) {
    this.subject = subject;
    this.daysUntilStarts = daysUntilStarts;
    this.daysToRun = subject.getDuration();
  }

  // subject getter
  public Subject getSubject() {
    return subject;
  }

  // gets the status of the course
  public Integer getStatus() {
    // if the course hasn't started
    if (daysUntilStarts > 0) return -daysUntilStarts;
    // if the course has finished
    if (daysToRun == 0) return 0;
    
    // if the course is currently running
    return daysToRun;
  }

  // simulates a passing day
  public void aDayPasses() {
    // if the course hasnt started yet, it becomes a day closer to starting
    if (daysUntilStarts > 0) {
      daysUntilStarts--;
    } else if (daysToRun > 0) { // if the course started and a day passes, decrement the days of the course remaining, given that it hasn't finished
      daysToRun--;
    }
  }
}
