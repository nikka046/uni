// Main class
public class Main {
  // main method executed during runtime
  public static void main(String[] args) {
    // create a wolf and a parrot
    Wolf wolf = new Wolf("Johnny", 40);
    Parrot parrot = new Parrot("Steven", 3);

    // make both of them make some noise
    wolf.makeNoise();
    parrot.makeNoise();

    // print their names and ages
    System.out.println(wolf.getName()+": "+wolf.getAge());
    System.out.println(parrot.getName()+": "+parrot.getAge());

    // create meat and plant
    Meat meat = new Meat("meat");
    Plant plant = new Plant("plant");
  }
}
