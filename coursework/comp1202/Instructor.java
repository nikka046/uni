abstract class Instructor extends Person {
  private Course assignedCourse; // course assigned to the instructor

  // Instructor constructor
  public Instructor(String name, char gender, Integer age) {
    super(name, gender, age);
  }

  // assign given course to the instructor
  public void assignCourse(Course course) {
    assignedCourse = course;
  }

  // unassign curent course from the instructor
  public void unassignCourse() {
    assignedCourse = null;
  }

  public Course getAssignedCourse() {
    return assignedCourse;
  }

  abstract boolean canTeach(Subject subject);

  @Override
  public String toString() {
    return String.format("%s - assigned course: %s", getName(), assignedCourse == null ? "-" : assignedCourse.getSubject().getID().toString());
  }
}
