// Animal class
public abstract class Animal {
  private String name; // animal's name
  private int age; // age of the animal

  // animal constructor taking its name and age
  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
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
  abstract void eat(Food food) throws Exception;
}
