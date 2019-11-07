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
    users.add(new User("sj", "user", "Steve Jobs"));
    users.add(new User("steve", "admin", "Steven"));
    users.add(new User("bob", "admin", "Bob"));
    users.add(new User("adams", "editor", "Adam"));
    users.add(new User("sam1", "user", "Sam"));
    users.add(new User("andy", "editor", "Andrew"));
    users.add(new User("jack", "user", "Jack"));
    users.add(new User("jar", "user", "Jarred"));
    users.add(new User("mark", "admin", "Mark Zuckerberg"));
    users.add(new User("rick", "user", "Rick Astley"));
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
