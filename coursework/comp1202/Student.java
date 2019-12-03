import java.util.ArrayList;
import java.util.stream.Collectors;

class Student extends Person {
  private ArrayList<Integer> certificates; // list of subject IDs that the student has obtained
  private Course course; // stores the current course student is enrolled at
  
  // Student constructor
  public Student(String name, char gender, Integer age) {
    super(name, gender, age);
    certificates = new ArrayList<Integer>(); // by default a student will not have any certificates
  }
  
  // add given subject's id to the certificates
  public void graduate(Subject subject) {
    this.certificates.add(subject.getID());
  }

  // certificates getter
  public ArrayList<Integer> getCertificates() {
    return certificates;
  }

  // checks if given student has completed a given subject
  public boolean hasCertificate(Subject subject) {
    return certificates.contains(subject.getID());
  }

  // enrols a student in a course
  public void enrol(Course course) {
    this.course = course;
  }

  // release / un enrol from a course
  public void unassignCourse() {
    course = null;
  }

  // return true if student not enrolled in a course
  public Boolean isFree() {
    return course == null;
  }

  @Override
  public String toString() {
    return String.format(
        "%s - certificates: [%s]%s",
        getName(),
        certificates.stream().map(Object::toString).collect(Collectors.joining(", ")),
        course == null ? "" : ", course: "+course.getSubject().getID().toString()
    );
  }
}
