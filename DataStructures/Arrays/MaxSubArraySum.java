package DataStructures.Arrays;

public class MaxSubArraySum {

    // Kadane's algorithm to find maximum continous sum.
    public static int maxSubarraySum(int arr[]){
        int maxSoFar = arr[0];
        int maxEndHere = arr[0];
        int n = arr.length;
        for(int i = 1 ;i<n ;i++){
            maxEndHere = ArrayUtils.Max(arr[i],arr[i]+maxEndHere);
            maxSoFar = ArrayUtils.Max(maxEndHere,maxSoFar);
        }
        return maxSoFar;
    }


}
