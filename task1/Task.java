package task1;

import java.util.Scanner;
import java.util.ArrayList;


public class Task {


    /**
     * Complexity: O(1)
     */
    public static String getUserInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter any string:");

        String input = sc.nextLine();
        sc.close();

        return input;
    }

    /**
     * Complexity: O(N*N)
     */
    public static ArrayList<String> getSubstrings(String userInput) {
        ArrayList<String> subStrings = new ArrayList<>();
        StringBuilder sBuilder = new StringBuilder();

        for (int i = 0; i < userInput.length(); i++) { // O(N)
            if (!isBigger(userInput, i)) {
                subStrings.add(new String(sBuilder)); // O(1)
                sBuilder.delete(0, sBuilder.length()); // O(N)
            }
            sBuilder.append(userInput.charAt(i)); // O(1)

            if (i == userInput.length() - 1) {
                subStrings.add(new String(sBuilder)); // O(1)
            }
        }

        return subStrings;
    }

    /**
     * Complexity: O(1)
     */
    public static boolean isBigger(String userInput, int index) {
        if (index == 0) {
            return true;
        } else {
            return userInput.charAt(index) > userInput.charAt(index - 1);
        }
    }

    /**
     * Complexity: O(N)
     */
    public static String getLongestSubstring(ArrayList<String> subStings) {
        int maxLength = 0;
        String longestString = null;

        for (String s : subStings) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                longestString = s;
            }
        }
        return longestString;
    }

    /**
     * Complexity: O(1)
     */
    public static void showOutput(String subString) {
        System.out.println("Longest substring length: " + subString.length());
    }

    /**
     *  Summary complexity: O(1) + O(N*N) + O(N) + O(1) = O(2N*N) = O(N*N)
     */
    public static void main(String[] args) {
        String userInput = getUserInput();
        ArrayList<String> subStrings = getSubstrings(userInput);
        String longestSubString = getLongestSubstring(subStrings);
        showOutput(longestSubString);
    }
}
