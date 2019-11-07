import java.util.*;

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

  // combines two wordgroups into a single hash set
  public HashSet<String> getWordSet(WordGroup otherGroup) {
    // create a hash set that the items will be added to
    HashSet<String> set = new HashSet();
    
    // get the array of words in THIS group
    String[] wordArray = getWordArray();
    // add all the items in the array to the set
    for (int i = 0; i < wordArray.length; i++) {
      set.add(wordArray[i]);
    }
    
    // get the array of words in the other group
    String[] otherWordArray = otherGroup.getWordArray();
    // add all the items in the array to the set
    for (int i = 0; i < otherWordArray.length; i++) {
      set.add(otherWordArray[i]);
    }

    // return the hash set
    return set;
  }
}
