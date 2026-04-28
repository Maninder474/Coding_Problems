package DataStructures.Strings;

import DataStructures.util.time.Clock;

public class StringsTest {
    static String TestDataString = "A man, a plan, a canal: Panama";

    public static void isPalindrome(Clock clock) {
        clock.start();
        boolean res = IsPalindrome.isPalindrome(TestDataString);
        clock.stop();
        System.out.println("Is Palindrome : " + res);
        System.out.println("Time taken : " + clock.getTotalTime() + " ms");
    }

    public static void reverseString(Clock clock) {
        clock.start();
        String reversed = ReverseString.reverseString(TestDataString);
        clock.stop();
        System.out.println("Reversed String : " + reversed);
        System.out.println("Time taken : " + clock.getTotalTime() + " ms");
    }

    public static void isValidParentheses(Clock clock) {
        clock.start();
        boolean res = ValidParentheses.isValidParentheses(TestDataString);
        clock.stop();
        System.out.println("Is Valid Parentheses : " + res);
        System.out.println("Time taken : " + clock.getTotalTime() + " ms");
    }

    public static void encodeDecodeStrings(java.util.List<String> listStr, Clock clock) {
        clock.start();
        String encodedStr = StringsUtil.encode(listStr);
        clock.stop();
        System.out.println("Encoded String : " + encodedStr);
        System.out.println("Time taken for encoding : " + clock.getTotalTime() + " ms");

        clock.start();
        java.util.List<String> decodedList = StringsUtil.decode(encodedStr);
        clock.stop();
        System.out.println("Decoded Strings : " + decodedList);
        System.out.println("Time taken for decoding : " + clock.getTotalTime() + " ms");
    }

    public static void groupAnagrams(Clock clock) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        clock.start();
        java.util.List<java.util.List<String>> groupedAnagrams = GroupAnagrams.groupAnagrams(strs);
        clock.stop();
        System.out.println("Grouped Anagrams : " + groupedAnagrams);
        System.out.println("Time taken : " + clock.getTotalTime() + " ms");
    }


}
