class Main {
  public static void main(String[] args) {
    System.out.println(args[0]);
    Administrator admin = new Administrator("");

    try {
      admin.run();
    } catch(Exception e) {
      
    }
  }
}
