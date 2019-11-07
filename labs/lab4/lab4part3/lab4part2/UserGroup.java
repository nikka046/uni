import java.util.ArrayList;

// UserGroup class
public class UserGroup {
  private ArrayList<User> users; // users property

  // UserGroup class constructor
  public UserGroup() {
    this.users = new ArrayList<User>();
  }
  
  // users getter
  ArrayList<User> getUsers() {
    return users;
  }

  // adds sample data with 10 exactly the same users
  void addSampleData() {
    // create sample user
    User sampleUser = new User("sj", "user", "Steve Jobs");
    // create loop that runs 10 times
    for (int i = 0; i < 10; i++) {
      // add sample user
      users.add(sampleUser);
    }
  }
  
  // get user by its position in the array
  User getUser(int index) {
    return users.get(index);
  }
  
  // print table of users
  void printUsernames() {
    // iterate through all users in the array list
    for(User user: users) {
      // for each user, print their username and user type
      System.out.println(user.getUsername()+" "+user.getUserType());
    }
  }
}
