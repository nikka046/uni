import java.util.ArrayList;

// Quiz class
class Quiz {
  private ArrayList<FlashCard> flashCards; // list of flash cards that will be created from constructor

  // Quiz constructor
  public Quiz(String filename) {
    // initialize the reader
    FlashCardReader reader = new FlashCardReader(filename);
    // get flash card from the file
    flashCards = reader.getFlashCards();

    play();
  }

  // play method used by the user to start the game
  public void play() {
    // create the toolbox
    Toolbox toolbox = new Toolbox();
    // go through all the cards
    for (FlashCard flashCard : flashCards) {
      // print out the question
      System.out.println(flashCard.getQuestion());
      // obtain user's answer
      String answer = toolbox.readStringFromCmd();
      // if answer is correct
      if (answer.equals(flashCard.getAnswer())) {
        System.out.println("right");
      } else {
        // if answer is incorrect
        System.out.println("Wrong, the correct answer is: " + flashCard.getAnswer());
      }
    }
  }

  // main method to make a new quiz
  public static void main(String[] args) {
    Quiz quiz = new Quiz("Questions.txt");
    quiz.play();
  }
}
