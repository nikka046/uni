// Herbivore class
abstract class Herbivore extends Animal {
  // Herbivore constructor
  public Herbivore(String name, Integer age) {
    super(name, age);
  }
  
  // implements the eat method and prints out the name of the food its eating
  public void eat(Food food) throws Exception {
    // if food is meat, throw an exception
    if (food instanceof Meat) {
      throw new Exception("Herbivores don't eat meat");
    }
    // else print a message saying that we are eating the food
    System.out.println("a Herbivore is eating the " + food.getName());
  }
}
