// Animal class
public abstract class Animal {
  private String name; // animal's name
  private int age; // age of the animal

  // animal constructor taking its name and age
  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // animal constructor that takes no arguments
  public Animal() {
    this("newborn", 0);
  }

  // name getter
  public String getName() {
    return name;
  }

  // age getter
  public int getAge() {
    return age;
  }

  // abstract makeNoise method to be implemented by subclasses
  public abstract void makeNoise();

  // eat method
  public abstract void eat(Food food) throws Exception;

  // overloaded eat method that also takes the quantity
  public void eat(Food food, Integer quantity) throws Exception {
    // track the amount of food consumed
    Integer consumed = 0;
    while (consumed < quantity) {
      eat(food);
      consumed++;
    }
  }
}
