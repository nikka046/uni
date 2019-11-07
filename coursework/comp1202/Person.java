class Person {
  private String name; // name of the person
  private char gender; // gender, either M (male) or F (female)
  private Integer age; // age of the person, in years

  // Person constructor
  public Person(String name, char gender, Integer age) {
    this.name = name;
    this.gender = gender;
    this.age = age;
  }
  
  // name getter
  public String getName() {
    return name;
  }

  // gender getter
  public char getGender() {
    return gender;
  }
  
  // age getter
  public Integer getAge() {
    return age;
  }
  
  // age setter
  public void setAge(Integer value) {
    age = value;
  }
}
