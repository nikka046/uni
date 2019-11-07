class Main {
  public static void main(String[] args) {
    System.out.println("yeah boi");
    Subject cs = new Subject(1, 1, 2, "Computer Science");
    Course course = new Course(cs, 1);
    System.out.println(" " + course.getStatus());
    // course.aDayPasses();
    System.out.println(" " + course.getStatus());

    Student boy1 = new Student("bob", 'M', 18);
    System.out.println(course.getSize());
    course.enrolStudent(boy1);
    System.out.println(course.getSize());

  }
}
