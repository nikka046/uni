import java.util.ArrayList;
import java.util.*;
import java.io.*;

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

  // removes the first user in the group
  void removeFirstUser() {
    users.remove(0);
  }

  // removes the last user in the group
  void removeLastUser() {
    users.remove(users.size() - 1);
  }
  
  // removes user by id
  void removeUser(String username) {
    Iterator iterator = users.iterator();
    // iterate through all the elements
    while(iterator.hasNext()) {
      User user = iterator.next();

      // if username matches the parameter, remove the user
      if (user.getUsername().equals(username)) {
        iterator.remove();
      }
    }
  }
  
  // returns users iterator
  Iterator<User> getUserIterator() {
    return users.iterator();
  }
}
