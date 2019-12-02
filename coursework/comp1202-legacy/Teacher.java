// Teacher class
class Teacher extends Instructor {
  // Teacher constructor
  public Teacher(String name, char gender, int age) {
    super(name, gender, age);
  }

  // returns true if the person is qualified to teach the subject
  boolean canTeach(Subject subject) {
    Integer specialism = subject.getSpecialism();
    return specialism == 1 || specialism == 2;
  }
}
