import java.util.Arrays;

class Course {
  private Subject subject; // subject associated with the course
  private Integer daysUntilStarts; // number of days until the course starts
  private Integer daysToRun; // number of remaining days the course still has to run
  private Student[] students = new Student[3]; // list of students that are enrolled in the course
  
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
      // if course has finished
      if (daysToRun == 0) {
        // issue certificates to all students
        for (int i = 0; i < getSize(); i++) {
          students[i].graduate(subject);
        }
        // remove graduates from students array
        students = new Student[getSize()];
      }
    }
  }

  // enrols a student
  public boolean enrolStudent(Student student) {
    Integer size = getSize();
    // size cannot exceed 3 and course cannot be already started
    if (size < 3 && daysUntilStarts > 0) {
      students[size] = student;
      return true;
    }
    return false;
  }

  // returns the number of students enrolled in the course
  public Integer getSize() {
    Integer size = 0;
    for(int i = 0; i < students.length; i++) {
      if (students[i] != null) {
        size++;
      } else {
        return size;
      }
    }
    return size;
  }

  // returns list of students
  public Student[] getStudents() {
    return Arrays.copyOfRange(students, 0, getSize());
  }
}
