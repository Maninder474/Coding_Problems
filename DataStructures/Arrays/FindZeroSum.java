package DataStructures.Arrays;

import java.util.HashSet;

public class FindZeroSum {

    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        int sum = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i:arr){
            sum+=i;
            if(i==0 || hs.contains(sum) || sum ==0)
                return true;
            hs.add(sum);
        }
        return false;
    }

}
