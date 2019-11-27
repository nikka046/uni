import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintStream;

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

    // ask the user if they want to save the game at the end
    String userWantsToSave;
    do {
      System.out.println("Would you like to save the file at the end?");
      userWantsToSave = toolbox.readStringFromCmd();
    } while (!(userWantsToSave.equals("Y") || userWantsToSave.equals("N")));

    // go through all the cards
    for (FlashCard flashCard : flashCards) {
      // print out the question
      System.out.println(flashCard.getQuestion());
      // obtain user's answer
      String answer = toolbox.readStringFromCmd();
      // if answer is correct
      if (flashCard.isCorrectAnswer(answer)) {
        System.out.println("right");
      } else {
        // if answer is incorrect
        System.out.println("Wrong, the correct answer is: " + flashCard.getAnswer());
      }
    }

    // check if we need to save
    if (userWantsToSave.equals("Y")) {
      save();
    }
  }

  private void save() {
    try {
      // initialise print stream file writer
      PrintStream file = new PrintStream("./save.txt");
      // get the total number of questions
      Integer total = flashCards.size();
      // Keep track of the score
      Integer score = 0;
      // go through all flash cards
      for (FlashCard card: flashCards) {
        // add flash card line to the file
        file.printf("%s,%s,%s\n", card.getQuestion(), card.getAnswer(), card.getStatus());
        // check if flash card was right and increment the score if it was
        if (card.getStatus().equals("right")) {
          score++;
        }
      }
      // add the summary
      file.printf("%d,%d,%.1f\n", score, total, 100 * (double)score / (double)total);
      // write to the file (and close it)
      file.close();
    } catch(FileNotFoundException err) {
    }
  }

  // main method to make a new quiz
  public static void main(String[] args) {
    Quiz quiz = new Quiz("Questions.txt");
    quiz.play();
  }
}
