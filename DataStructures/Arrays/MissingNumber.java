package DataStructures.Arrays;

public class MissingNumber {
    // Below method finds the missing number in the arry of continous number.
    public static int MissingNumber(int[] arr){
        int n = arr.length;
        int sum = n*(n-1)/2;
        int sum1  =0;
        for(int i : arr)
            sum1 += i;
        return sum1-sum;
    }
}
