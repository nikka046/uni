import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class FlashCardReader {
  private BufferedReader reader; // declared buffered reader to read the file later

  // FlashCardReader constructor
  public FlashCardReader(String filename) {
    try {
      this.reader = new BufferedReader(new FileReader(filename));
    } catch (FileNotFoundException e) {
      System.out.println("File '" + filename + "' could not be fould");
    }
  }

  public String getLine() {
    try {
      return reader.readLine();
    } catch (IOException e) {
      return null;
    }
  }

  public ArrayList<FlashCard> getFlashCards() {
    // create the arraylist
    ArrayList<FlashCard> flashCards = new ArrayList<FlashCard>();
    // initialise current line variable
    String currentLine;
    while ((currentLine = getLine()) != null) {
      // split the line by ":" to get the question and answer
      String[] parts = currentLine.split(":");
      flashCards.add(new FlashCard(parts[0], parts[1]));
    }
    return flashCards;
  }

  // returhs true if no errors and file is ready to read
  public boolean fileIsReady() {
    try {
      return reader.ready();
    } catch (Exception e) {
      return false;
    }
  }
}
