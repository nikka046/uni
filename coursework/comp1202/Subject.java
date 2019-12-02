// Subject class
class Subject {
  private Integer id; // subject ID
  private Integer specialism; // specialism ID
  private Integer duration; // number of days required for any course covering the subject
  private String description; // description of the subject
  
  // Subject constructor
  public Subject(Integer id, Integer specialism, Integer duration, String description) {
    this.id = id;
    this.specialism = specialism;
    this.duration = duration;
    this.description = description;
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
