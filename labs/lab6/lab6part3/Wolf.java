// Wolf class, a wolf is a carnivore
public class Wolf extends Carnivore {

  // Wolf constructor, taking its name and age
  public Wolf(String name, int age) {
    super(name, age);
  }

  // makes noise to standard output
  public void makeNoise() {
    System.out.println("woof");
  }
}
