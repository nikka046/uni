import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    } catch(IOException err) {
      return null;
    }
  }

  public boolean fileIsReady() {
    try {
      return reader.ready();
    } catch (Exception e) {
      return false;
    }
  }
}
