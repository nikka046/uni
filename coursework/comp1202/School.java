import java.util.ArrayList;
import java.util.Iterator;

class School {
  private String name; // School's name
  private ArrayList<Subject> subjects; // array list of subjects
  private ArrayList<Course> courses; // array list of courses
  private ArrayList<Instructor> instructors; // array list of instructors
  private ArrayList<Student> students; // array list of students

  // School constructor
  public School(String name) {
    this.name = name;
    subjects = new ArrayList<Subject>();
    courses = new ArrayList<Course>();
    instructors = new ArrayList<Instructor>();
    students = new ArrayList<Student>();
  }

  // name setter
  public void setName(String name) {
    this.name = name;
  }

  // adds a subject to the school
  public void add(Subject subject) {
    subjects.add(subject);
  }
  // removes a subject from the school
  public void remove(Subject subject) {
    subjects.remove(subject);
  }
  // returns an array of subjects
  public Subject[] getSubjects() {
    Subject[] subjects = new Subject[this.subjects.size()];
    this.subjects.toArray(subjects);
    return subjects;
  }

  // adds a course to the school
  public void add(Course course) {
    courses.add(course);
  }
  // removes a course from the school
  public void remove(Course course) {
    courses.remove(course);
  }
  // returns an array of courses
  public Course[] getCourses() {
    Course[] courses = new Course[this.courses.size()];
    this.courses.toArray(courses);
    return courses;
  }

  // adds an instructor to the school
  public void add(Instructor instructor) {
    instructors.add(instructor);
  }
  // removes an instructor from the school
  public void remove(Instructor instructor) {
    instructors.remove(instructor);
  }
  // returns an array of courses
  public Instructor[] getInstructors() {
    Instructor[] instructors = new Instructor[this.instructors.size()];
    this.instructors.toArray(instructors);
    return instructors;
  }

  // adds a student to the school
  public void add(Student student) {
    students.add(student);
  }
  // removes a student from the school
  public void remove(Student student) {
    students.remove(student);
  }
  // returns an array of students
  public Student[] getStudents() {
    Student[] students = new Student[this.students.size()];
    this.students.toArray(students);
    return students;
  }

  @Override
  public String toString() {
    return String.format("School: %s\n * subjects: %d\n * courses: %d\n * instructors: %d\n * students: %d", name, subjects.size(), courses.size(), instructors.size(), students.size());
  }

  // simulates events of the day at school
  public void aDayAtSchool() {
    // go through all the subjects
    for (Subject subject: subjects) {
      Boolean hasCourse = false;
      // find out whether the subject has a course
      for (Course course: courses) {
        if (course.getSubject() == subject) {
          hasCourse = true;
          break;
        }
      }
      // if subject doesn't have an open course, create it
      if (!hasCourse) {
        // new subject starts in 2 days
        add(new Course(subject, 2));
      }
    }

    // go through all students
    for (Student student: students) {
      // if student is not enrolled in any course
      if (student.isFree()) {
        // find a course that a student can join and doesn't have the certificate for
        for (Course course: courses) {
          if (course.getSize() < 3 && !student.hasCertificate(course.getSubject())) {
            course.enrolStudent(student); // enrol student
            break; // coruse already found, no need to find more
          }
        }
      }
    }

    Iterator<Course> iterator = courses.iterator();
    while (iterator.hasNext()) {
      Course course = iterator.next();
      // find each course that requires an instructor
      if (!course.hasInstructor()) {
        for (Instructor instructor: instructors) {
          // find the first suitable instructor and stop
          // instructor must not have an assigned course and must be able to teach the course
          if (instructor.getAssignedCourse() == null && course.setInstructor(instructor)) {
            break; // stop the for loop
          }
        }
      }
      // let the students learn
      course.aDayPasses();
      // remove cancelled or already finished courses
      if (course.isCancelled() || course.getStatus() == 0) {
        iterator.remove();
      }
    }
  }
}
