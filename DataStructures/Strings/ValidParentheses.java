package DataStructures.Strings;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValidParentheses(String s) {

        Stack<Character> st = new Stack<Character>();

        int i = 0, n = s.length();
        if(n%2==1)
            return false;
        char []str = s.toCharArray();
        while(i<n){
            if(str[i]=='(' || str[i]=='[' || str[i]=='{'){
                st.push(str[i++]);
                continue;
            }
            if(st.empty())
                return false;
            if(str[i]==')' && st.peek()!='(')
                return false;
            else if(str[i]=='}' && st.peek()!='{')
                return false;
            else if(str[i]==']' && st.peek()!='[')
                return false;
            else
                st.pop();
            i++;
        }
        return st.empty();
    }
}
