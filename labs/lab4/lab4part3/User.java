public class User {
  private String username; // username property
  private String userType; // user type property
  private String name; // user's name property
  
  // user constructor
  public User(String username, String userType, String name) {
    //set constructor arguments to class properties{
    this.username = username;
    this.userType = userType;
    this.name = name;
  }
  
  // username getter
  public String getUsername() {
    return username;
  }

  
  // userType getter
  public String getUserType() {
    return userType;
  }

  // name getter
  public String getName() {
    return name;
  }

  // userType setter
  void setUserType(String userType) {
    this.userType = userType;
  }
}
