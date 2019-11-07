// Omnivore class
abstract class Omnivore extends Animal {
  // Omnivore constructor
  public Omnivore(String name, Integer age) {
    super(name, age);
  }
  
  // implements the eat method and prints out the name of the food its eating
  public void eat(Food food) {
    System.out.println("a Omnivore is eating the " + food.getName());
  }
}
