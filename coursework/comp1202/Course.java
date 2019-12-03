import java.util.Arrays;
import java.util.stream.Collectors;

class Course {
  private Subject subject; // subject associated with the course
  private Integer daysUntilStarts; // number of days until the course starts
  private Integer daysToRun; // number of remaining days the course still has to run
  private Student[] students = new Student[3]; // list of students that are enrolled in the course
  private Instructor instructor; // current course instructor
  private Boolean cancelled = false; // defines whether course has been cancelled
  
  // Course constructor
  public Course(Subject subject, Integer daysUntilStarts) {
    this.subject = subject;
    this.daysUntilStarts = daysUntilStarts;
    this.daysToRun = subject.getDuration();
  }

  // instructor setter
  // returns true if instructor changed
  public Boolean setInstructor(Instructor instructor) {
    // check if instructor can teach the subject
    if (instructor.canTeach(subject)) {
      instructor.assignCourse(this);
      this.instructor = instructor;
      return true;
    }
    return false;
  }

  // returns true if instrutor already set
  public Boolean hasInstructor() {
    return instructor != null;
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

  // cancelled getter
  public Boolean isCancelled() {
    return cancelled;
  }

  private void releaseStudentsAndInstructor() {
    for (Student student: students) {
      if (student != null) student.unassignCourse();
    }
    // remove graduates from students array
    students = new Student[getSize()];
    // unassign instructor
    if (hasInstructor()) {
      instructor.unassignCourse();
      instructor = null;
    }
  }

  // simulates a passing day
  public void aDayPasses() {
    // cancel the course if instructor not present at the start or no students
    if (daysUntilStarts == 1 && (!hasInstructor() || getSize() == 0)) {
      cancelled = true;
      releaseStudentsAndInstructor();
    } else if (daysUntilStarts > 0) { // if the course hasnt started yet, it becomes a day closer to starting
      daysUntilStarts--;
    } else if (daysToRun > 0) {
      // if the course started and a day passes, decrement the days of the course remaining,
      // given that it hasn't finished
      daysToRun--;
      // if course has finished
      if (daysToRun == 0) {
        // issue certificates to all students
        for (int i = 0; i < getSize(); i++) {
          students[i].graduate(subject);
        }
        releaseStudentsAndInstructor();
      }
    }
  }

  // enrols a student
  public Boolean enrolStudent(Student student) {
    Integer size = getSize();
    // size cannot exceed 3 and course cannot be already started
    if (size < 3 && daysUntilStarts > 0) {
      students[size] = student;
      student.enrol(this);
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

  @Override
  public String toString() {
    return String.format(
        "%s(%s):\t[%s]",
        subject.getID().toString(),
        getStatus(),
        Arrays.stream(getStudents()).map((s) -> s.getName()).collect(Collectors.joining(","))
    );
  }
}
