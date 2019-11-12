// Wolf class
public class Wolf extends Carnivore {

  // Wolf constructor, taking its name and age
  public Wolf(String name, int age) {
    super(name, age);
  }

  // Empty Wolf constructor
  public Wolf() {
    super();
  }

  // makes noise to standard output
  public void makeNoise() {
    System.out.println("woof");
  }
}
