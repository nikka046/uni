// parrot class, parrot is an animal
public class Parrot extends Animal {
  
  // Parrot constructor taking its name and age
  public Parrot(String name, int age) {
    // pass the name and age to the parent (Animal) class
    super(name, age);
  }

  // makes noise to standard output
  public void makeNoise() {
    System.out.println("reeeee");
  }
}
