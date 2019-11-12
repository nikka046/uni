import java.util.ArrayList;
import java.util.Collections;

// Demo class
class Demo {
  public static void main(String[] args) {
    ArrayList<Animal> animals = new ArrayList<Animal>();

    animals.add(new Wolf("wolf 1", 12));
    animals.add(new Parrot(2));
    animals.add(new Wolf("wolf 2", 3));
    // An interface is line an abstract class that can be used to group related
    // methods
    // It cannot contain properties or constructors
    // Also, classes "implement" interfaces, not "extend"

    printAnimals(animals);
    // sort the animals ArrayList
    Collections.sort(animals);
    // print the sorted animals
    printAnimals(animals);
  }

  // method used to print a list of animals' ages
  static void printAnimals(ArrayList<Animal> animals) {
    // go through all animals
    for (Animal animal : animals) {
      // print their ages
      System.out.print(new Integer(animal.getAge()).toString() + ", ");
    }
    System.out.println();
  }
}
