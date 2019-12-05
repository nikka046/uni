// Subject class
class Subject {
  private Integer id; // subject ID
  private Integer specialism; // specialism ID
  private Integer duration; // number of days required for any course covering the subject
  private String description; // description of the subject
  private Subject[] prerequisites; // list of prerequisite subjects ifor a given subject
  
  // Subject constructor, subject prerequisites are optional
  public Subject(Integer id, Integer specialism, Integer duration, Subject... prerequisites) {
    this.id = id;
    this.specialism = specialism;
    this.duration = duration;
    this.prerequisites = prerequisites;
  }


  // ensures that students can only enrol on a course if they have all prerequisites
  // returns true if student has all prerequisites
  public Boolean hasAllPrerequisites(Student student) {
    // go through all prerequisites
    for (Subject prerequisite: prerequisites) {
      // if any of the prerequisites is not met by the student, return false
      if (!student.hasCertificate(prerequisite)) return false;
    }
    // all prerequisites met, return true
    return true;
  }

  // id getter
  public Integer getID() {
    return id;
  }
  
  // specialism getter
  public Integer getSpecialism() {
    return specialism;
  }

  // duration getter
  public Integer getDuration() {
    return duration;
  }

  // description getter
  public String getDescription() {
    return description;
  }

  // description setter
  public void setDescription(String value) {
    description = value;
  }
}
