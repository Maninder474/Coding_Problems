package main;

import DataStructures.Arrays.ArraysTest;
import DataStructures.Strings.StringsTest;
import DataStructures.util.time.Clock;

/**
 * Hello
 */
public class Hello {

    public static void main(String[] args) {

        Clock clock = new Clock();

        System.out.println("Arrays Test Cases:");
        ArraysTest.topKFrequent(clock);
        ArraysTest.productExceptSelf(clock);
        ArraysTest.productExceptSelfMedium(clock);
        ArraysTest.kthSmallestInteger();

        System.out.println("\nStrings Test Cases:");
         StringsTest.isPalindrome(clock);
         StringsTest.reverseString(clock);
         StringsTest.isValidParentheses(clock);
         java.util.List<String> listStr = new java.util.ArrayList<String>();
         listStr.add("Hello");
         listStr.add("World");
         listStr.add("This is a test string with special characters !@#$%^&*()");
         StringsTest.encodeDecodeStrings(listStr, clock);

    }



}
