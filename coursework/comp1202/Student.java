import java.util.ArrayList;

class Student extends Person {
  private ArrayList<Integer> certificates; // list of subject IDs that the student has obtained
  
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
}
