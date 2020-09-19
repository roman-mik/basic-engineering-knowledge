package task1;

import java.util.Scanner;
import java.util.ArrayList;

public class Task {

  public static String getUserInput() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Please enter any string:");

    String input = sc.nextLine();
    sc.close();

    return input;
  }

  public static ArrayList<String> getSubstrings(String userInput) {
    ArrayList<String> subStrings = new ArrayList<String>();
    StringBuilder sBuilder = new StringBuilder();

    for (int i = 0; i < userInput.length(); i++) {
      if (isBigger(userInput, i)) {
        sBuilder.append(userInput.charAt(i));
      } else {
        subStrings.add(new String(sBuilder));
        sBuilder.delete(0, sBuilder.length());
      }
    }

    return subStrings;
  }

  public static boolean isBigger(String userInput, int index) {
    if (index == 0) {
      return true;
    } 
    else {
      return userInput.charAt(index) > userInput.charAt(index - 1);
    }
  }

  public static String getLongestSubstring(ArrayList<String> subStings) {
    int firstString = subStings.get(0).length();
    int index = 0;

    for (int i = 0; i < subStings.size(); i++) {
      if (subStings.get(i).length() > firstString) {
        firstString = subStings.get(i).length();
        index = i;
      }
    }

    return subStings.get(index);
  }

  public static void showOutput(String subString) {
    System.out.println(subString.length());
  }

  public static void main(String[] args) {
    String userInput = getUserInput();
    ArrayList<String> subStrings = getSubstrings(userInput);
    String longestSubString = getLongestSubstring(subStrings);
    showOutput(longestSubString);
  }
}
