import java.util.*;
import java.io.*;

// the main class
public class Main {
  // main function run on execution
  public static void main(String[] args) {
    // create a new toolbox
    Toolbox toolbox = new Toolbox();
    // ask user for an integer input
    int userNumber = toolbox.readIntegerFromCmd();
    
    // create a loop with numbers from 1 to 20
    for (int i = 1; i <= 20; i++) {
      System.out.print((i * userNumber)+", ");
    }
    System.out.println(); // end the line


    // create integer variables to track the total and number of attempts
    int total = 0;
    int nOfAttempts = 0;
    // as long as the total is below or equal to 500
    while(total <= 500) {
      // add 1 to the number of attempts, add the new number of attempts to the total
      total += ++nOfAttempts;
    }
    // print the number of attempts
    System.out.println(nOfAttempts);
    
    UserGroup userGroup = new UserGroup(); // create a user group
    // add 10 sample users
    userGroup.addSampleData();
    // print list of users
    userGroup.printUsernames();
    
    // create another user group for administrators
    UserGroup administrators = new UserGroup();

    // get the iterators
    Iterator<User> iterator = userGroup.getUserIterator();
    Iterator<User> administratorsIterator = administrators.getUserIterator();
    // while there are elements in the list
    while (iterator.hasNext()) {
      // get the next user
      User user = iterator.next();
      
      // if the user is an admin, add it to the administrators list
      if (user.getUserType() == "admin") {
        administratorsIterator.add(user);
      }
    }

    administrators.printUsernames();
  }
}
