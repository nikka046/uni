// Animal class
public abstract class Animal {
  private String name; // name property
  private int age; // age property

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
}
