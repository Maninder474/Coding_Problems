package DataStructures.Arrays;

import java.util.ArrayList;

public class SubArraySum {
    //Below Method finds subarray with a given sum
    public static ArrayList<Integer> subarraySum(int[] arr, int sum){
        int n = arr.length;
        int x = -1,y=-1,l_sum = 0;
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i =0;i<n;i++)
        {
            x = i;
            for(int j = i;j<n;j++){
                l_sum = l_sum+arr[j];
                if(l_sum == sum){
                    y = j;
                    break;
                }else if (l_sum>sum){
                    l_sum =0;
                    break;
                }
            }
            if(sum==l_sum){
                for(int k = x;k<=y;k++)
                    al.add( arr[k]);
                break;
            }
        }
        return null;
    }
}
