import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// class useed to read simulation config file
// returns true if successfull
// returns false if there was an error parsing
class SimulationConfig {

  public static Boolean saveFile(String filename, School school) {
    try {
      File file = new File(filename);
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));

      writer.write("school:"+school.getName());
      writer.newLine();

      for (Student s: school.getStudents()) {
        writer.write("student:"+s.toLine());
        writer.newLine();
      }
      writer.close();
      return true;
    } catch (IOException e) {
      return false;
    }
  }

  // reads the file located in the "filename"
  // can either take a relative filename or absolute path to file
  // appends changes to school parameter
  // returns true if success, false if failed
  public static Boolean readFile(String filename, School school) {
    try {
      File file = new File(filename);
      BufferedReader reader = new BufferedReader(new FileReader(file));

      String line;
      // for each line in the configuration file
      while ((line = reader.readLine()) != null) {
        // get the parts on both sides of the ":"
        String[] parts = line.split(":");

        // define shared variables used by student, subject and instructors
        String[] subParts = new String[0];
        String name = "";
        char gender = ' ';
        Integer age = 0;
        
        // if uses subparts
        if (parts.length >= 2) {
          subParts = parts[1].split(",");
          // try parsing these, ignore if fails to parse
          try {
            // parse properties for student and instructors
            name = subParts[0];
            gender = subParts[1].charAt(0);
            age = Integer.parseInt(subParts[2]);
          } catch (Exception e) {
            // simply ignore invalid configuration
          }
        }

        // instead of using multiple if statements, switch is more efficient
        // adds appropriate objects to the school
        switch(parts[0]) {
          // changes school's name
          case "school":
            school.setName(parts[1]);
            break;
          // parse and add a subject
          case "subject":
            String description = subParts[0];
            Integer subjectID = Integer.parseInt(subParts[1]);
            Integer specialisationID = Integer.parseInt(subParts[2]);
            Integer duration = Integer.parseInt(subParts[3]);
            Subject subject = new Subject(subjectID, specialisationID, duration);
            subject.setDescription(description);
            school.add(subject);
            break;
          // constructor for a student
          case "student":
            school.add(new Student(name, gender, age));
            break;
          // constructors for valid types of instructors
          case "Teacher":
            school.add(new Teacher(name, gender, age));
            break;
          case "OOTrainer":
            school.add(new OOTrainer(name, gender, age));
            break;
          case "GUITrainer":
            school.add(new GUITrainer(name, gender, age));
            break;
          case "Demonstrator":
            school.add(new Demonstrator(name, gender, age));
            break;
          // prints an error about the token being invalid
          default:
            System.out.printf("invalid token: '%s'\n", parts[0]);
        }
      }
      // remember to close the file
      reader.close();
      // success, everything parsed properly
      return true;
    } catch(IOException e) {
      // error
      return false;
    }
  }
}
