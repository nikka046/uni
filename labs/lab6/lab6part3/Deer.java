class Deer extends Herbivore {
  // Deer constructor
  public Deer(String name, Integer age) {
    super(name, age);
  }

  // implement makeNoise
  public void makeNoise() {
    System.out.println("beeeep");
  }
}
