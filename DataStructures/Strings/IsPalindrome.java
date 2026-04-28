package DataStructures.Strings;

public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !StringsUtil.isAlphaNum(s.charAt(l))) {
                l++;
            }
            while (r > l && !StringsUtil.isAlphaNum(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++; r--;
        }
        return true;
    }
}
