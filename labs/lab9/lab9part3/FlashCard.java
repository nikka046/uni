
// the Flash Card class
class FlashCard {
  private String question; // question property
  private String answer; // answer property
  private Boolean status; // status property, defines whether the user got the question right or wrong

  // FlashCard Constructor taking a question and answer as arguments
  public FlashCard(String question, String answer) {
    // initialize class properties with the given arguments
    this.question = question;
    this.answer = answer;
  }

  // question getter
  public String getQuestion() {
    return question;
  }

  // answer getter
  public String getAnswer() {
    return answer;
  }

  // status getter
  public String getStatus() {
    return status ? "right" : "wrong";
  }

  // returns true if the answer matches the actual answer
  // changes the value of the status
  public Boolean isCorrectAnswer(String answer) {
    Boolean isCorrect = answer.equals(this.answer);
    // update status
    this.status = isCorrect;
    return isCorrect;
  }
}
