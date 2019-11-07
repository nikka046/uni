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
    System.out.println(); // add a new line to separate results
    
    // get the map with words and their counted occurences
    HashMap<String, Integer> wordCounts1 = wordGroup1.getWordCounts();
    // iterate over all the words and print their occurences
    for (String word: wordCounts1.keySet()) {
      // get the count by the word
      Integer count = wordCounts1.get(word);
      System.out.println(word + ": " + count);
    }
    System.out.println(); // print a new line to separate results
     
    // get the map with words and their counted occurences
    HashMap<String, Integer> wordCounts2 = wordGroup2.getWordCounts();
    // iterate over all the words and print their occurences
    for (String word: wordCounts2.keySet()) {
      // get the count by the word
      Integer count = wordCounts2.get(word);
      System.out.println(word + ": " + count);
    }
    System.out.println(); // print a new line to separate results
  }
}
