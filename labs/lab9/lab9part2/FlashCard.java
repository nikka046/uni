
// the Flash Card class
class FlashCard {
  private String question; // question property
  private String answer; // answer property

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
}
