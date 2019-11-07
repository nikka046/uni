import java.util.*;

// Main class
public class Main {
  // main method executed when the program is ran
  public static void main(String[] args) {
    // create the two words groups
    WordGroup wordGroup1 = new WordGroup("You can discover more about a person in an hour of play than in a year of conversation");
    WordGroup wordGroup2 = new WordGroup("When you play play hard when you work dont play at all");
  
    // get word arrays for both word groups
    String[] wordsArray1 = wordGroup1.getWordArray();
    String[] wordsArray2 = wordGroup2.getWordArray();
    
    // print out words in the first array
    for(int i = 0; i < wordsArray1.length; i++) {
      System.out.println(wordsArray1[i]);
    }
    System.out.println(); // add a new line to separate both results
    // print out words in the second array
    for(int i = 0; i < wordsArray2.length; i++) {
      System.out.println(wordsArray2[i]);
    }
    System.out.println(); // add a new line to separate from the next result
    
  
    // get the hash set of words
    HashSet<String> wordSet = wordGroup1.getWordSet(wordGroup2);
    // iterate over all words and print each one of them
    for (String word: wordSet) {
      System.out.println(word);
    }
  }
}
