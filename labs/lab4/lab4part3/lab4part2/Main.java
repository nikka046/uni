// the main class
public class Main {
  // main function run on execution
  public static void main(String[] args) {
    Toolbox toolbox = new Toolbox();
    int userNumber = toolbox.readIntegerFromCmd();
    
    for (int i = 1; i <= 20; i++) {
      System.out.print((i * userNumber)+", ");
    }
    System.out.println();

    int total = 0;
    int nOfAttempts = 0;
    while(total <= 500) {
      total += ++nOfAttempts;
    }
    System.out.println(nOfAttempts);
  }
}
