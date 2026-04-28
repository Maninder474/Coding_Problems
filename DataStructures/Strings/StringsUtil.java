package DataStructures.Strings;

import java.util.List;
import java.util.ArrayList;

public class StringsUtil {

    public static boolean isAlphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }

    public static String encode(List<String> strs) {
        StringBuilder st = new StringBuilder();
        for(String str : strs)
            st.append(str.length()).append("#").append(str);
        return st.toString();
    }

    public static List<String> decode(String str) {

        List<String> res = new ArrayList<String>();
        int i = 0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j)!='#')
                j++;
            int length = Integer.parseInt(str.substring(i,j));
            i = j+1;
            j = i+length;
            res.add(str.substring(i,j));
            i=j;
        }
        return res;

    }

}
