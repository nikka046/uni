import java.util.UUID;

// runs school as a Simulation
class Administrator {
  private School school; // school that will be simulated
  private static Toolbox toolbox = new Toolbox(); // toolbox used to get random integer
  private String configFile; // store the config file path to save it later

  public static void main(String[] args) {
    // initialise administrator class
    // use the first argument as the file name
    Administrator admin = new Administrator(args[0]);

    try {
      // run the program x times, where x is the 2nd argument
      admin.run(Integer.parseInt(args[1]));
    } catch(Exception e) {
    }
    admin.save();
  }

  // constructor that takes a path to the config file
  // initialises the school as well as subjects, courses, students, and instructors
  public Administrator(String configFile) {
    this.configFile = configFile;
    school = new School("Simulated School");

    Subject basics = new Subject(1, 1, 5);
    Subject lab1 = new Subject(2, 2, 2, basics);
    Subject arrays = new Subject(3, 1, 3, basics);
    Subject algorithms = new Subject(4, 1, 1, basics, arrays);
    Subject testing = new Subject(5, 1, 3, basics);
    Subject lab2 = new Subject(6, 2, 2, basics, lab1, algorithms, testing);
    
    school.add(basics);
    school.add(lab1);
    school.add(arrays);
    school.add(algorithms);
    school.add(testing);
    school.add(lab2);

    school.add(new Course(basics, 0));
    school.add(new Course(basics, 20));
    school.add(new Course(lab1, 2));
    school.add(new Course(lab1, 7));
    school.add(new Course(arrays, 7));
    school.add(new Course(arrays, 1));

    Boolean success = SimulationConfig.readFile(configFile, school);

    System.out.println(success ? "y" : "n");
  }

  // saves the config
  public void save() {
    SimulationConfig.saveFile(configFile, school);
  }

  // runs the simulation for 1 day
  public void run() {
    // generates a random number, either 1 or 2
    // indicates how manu new students will be added to the school
    Integer nOfNewStudents = toolbox.getRandomInteger(2);
    // generate and add given amount of students
    for (int i = 0; i < nOfNewStudents; i++) {
      school.add(generateStudent()); 
    }
    
    // generate a new instructor instance based on each probability
    if (getProbability(20))
      school.add(new Teacher(randomName(), randomGender(), randomAge()));
    if (getProbability(10))
      school.add(new Demonstrator(randomName(), randomGender(), randomAge()));
    if (getProbability(5))
      school.add(new OOTrainer(randomName(), randomGender(), randomAge()));
    if (getProbability(5))
      school.add(new GUITrainer(randomName(), randomGender(), randomAge()));

    // run the school
    school.aDayAtSchool();

    // free instructors have 20% chance of leaving the school
    for (Instructor instructor: school.getInstructors()) {
      if (instructor.getAssignedCourse() == null && getProbability(20)) {
        school.remove(instructor);
      }
    }

    // students that have obtained all certificates can leave the school
    for (Student student: school.getStudents()) {
      // unenrolled students have 5% chance of leaving
      if (student.isFree() && getProbability(5)) {
        school.remove(student);
      } else {
        // check if student hasAll certificates
        Boolean hasAll = true;
        for (Subject subject: school.getSubjects()) {
          if (!student.hasCertificate(subject)) hasAll = false;
        }
        // if yes, remove the student from the school
        if (hasAll) {
          school.remove(student);
        }
      }
    }

    // clear previous state
    System.out.print("\033[H\033[2J");  
    System.out.flush();
    // print school state
    System.out.println(school.toString() + "\n");

    System.out.println("Courses:");
    for (Course course: school.getCourses()) {
      System.out.println("\t" + course.toString());
    }

    System.out.println("Students:");
    for (Student student: school.getStudents()) {
      System.out.println("\t" + student.toString());
    }

    System.out.println("Instructors: ");
    for (Instructor instructor: school.getInstructors()) {
      System.out.println("\t" + instructor.toString());
    }
  }

  // generates a random UUID string
  private String randomName() {
    return UUID.randomUUID().toString().split("-")[0];
  }

  // generates a random gender char
  private char randomGender() {
    Boolean isMale = toolbox.getRandomInteger(2) == 2;
    return isMale ? 'M' : 'F';
  }

  // generates a random age between 18 and 55
  private Integer randomAge() {
    return toolbox.getRandomInteger(55 - 18) + 18;
  }

  // generates a student with a random name, gender, and age
  private Student generateStudent() {
    return new Student(randomName(), randomGender(), randomAge());
  }

  // generates probability based on a percentage
  private Boolean getProbability(Integer percentage) {
    Integer randomPercentage = toolbox.getRandomInteger(100);
    return randomPercentage <= percentage;
  }

  // generates an instructor based on the probabilities

  // overload of run
  // allows to specify the amount of days to run for
  // Thread.sleep can throw InterruptedException
  public void run(Integer days) throws InterruptedException {
    for (Integer i = 0; i < days; i++) {
      run();
      try {
        Thread.sleep(50);
      }
      catch(InterruptedException e) {
      }
    }
  }
}
