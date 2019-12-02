// Demonstrator class
class Demonstrator extends Instructor {
  // Demonstrator constructor
  public Demonstrator(String name, char gender, int age) {
    super(name, gender, age);
  }

  // returns true if the person is qualified to teach the subject
  boolean canTeach(Subject subject) {
    Integer specialism = subject.getSpecialism();
    return specialism == 2;
  }
}
