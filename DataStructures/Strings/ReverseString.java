package DataStructures.Strings;

public class ReverseString {
    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        return reverseString(charArray);
    }

    public static String reverseString(char[] charArray) {
        int left = 0, right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left]=charArray[right];
            right--;
            left++;
        }
        return new String(charArray);
    }
}
