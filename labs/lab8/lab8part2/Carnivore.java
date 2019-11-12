// Carnivore class
abstract class Carnivore extends Animal {
  // Carnivore constructor
  public Carnivore(String name, Integer age) {
    super(name, age);
  }

  // Empty Carnivore constructor
  public Carnivore() {
    super();
  }

  // implements the eat method and prints out the name of the food its eating
  public void eat(Food food) throws Exception {
    // only allow eating meat
    if (food instanceof Meat) {
      System.out.println("a Carnivore is eating the " + food.getName());
    } else {
      // throw exception if it's a plant
      throw new Exception("Food must be Meat");
    }
  }
}
