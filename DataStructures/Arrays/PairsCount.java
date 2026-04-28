package DataStructures.Arrays;

import java.util.HashMap;

public class PairsCount {
    //function to count the number of pairs whose sum is zero
    public static int getPairsCount(int[] arr,int k){
        int count=0;
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        for (int j : arr) {
            if (hs.containsKey(k - j))
                count = count + hs.get(k - j);
            if (hs.containsKey(j))
                hs.put(j, hs.get(j) + 1);
            else
                hs.put(j, 1);
        }
        return count;
    }
}
