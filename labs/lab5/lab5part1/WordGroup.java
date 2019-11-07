// WordGroup class
public class WordGroup {
  private String words; // String property containing words

  // WordGroup constructor
  public WordGroup(String words) {
    // converts the string to lowercase
    this.words = words.toLowerCase();
  }
  
  // returns an array of words (each word is separated by a space)
  public String[] getWordArray() {
    return words.split(" ");
  }
}
