// GUITrainer class
class GUITrainer extends Instructor {
  // GUITrainer constructor
  public GUITrainer(String name, char gender, int age) {
    super(name, gender, age);
  }

  // returns true if the person is qualified to teach the subject
  boolean canTeach(Subject subject) {
    Integer specialism = subject.getSpecialism();
    return specialism == 1 || specialism == 2 || specialism == 4;
  }
}
