package DataStructures.Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class Arrays {

    //function to count the number of pairs whose sum is zero
    public static int getPairsCount(int[] arr,int k){
        int count=0;
        int n = arr.length;
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        for(int i = 0;i<n;i++){
            if(hs.containsKey(k-arr[i]))
                count=count+hs.get(k-arr[i]);
            if(hs.containsKey(arr[i]))
                hs.put(arr[i],hs.get(arr[i])+1);
            else
                hs.put(arr[i],1);
        }
        return count;
    }


    // normal version of rotate array
    static void rotateArr(int arr[], int d, int n)
    {
        int temp =0;
        if(d>=n){
            d=d%n;
        }
        if(d<n/2){
            for(int i = 0;i<d;i++){
                temp = arr[0];
                for(int j = 1;j<n;j++){
                    arr[j-1]=arr[j];
                }
                arr[n-1]=temp;
            }
        }else{
            for(int i = 0;i<n-d;i++){
                temp = arr[n-1];
                for(int j = n-2;j>=0;j--){
                    arr[j+1]=arr[j];
                }
                arr[0]=temp;
            }
        }
    }

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

    // this function returns the kth smallest element using quick sort logic 
    // modify the pivot funtion to get the kth largest as will by changing the less then equal to to greaterthen sign.
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        if(k>0 && k<= r-l+1){
            int pos = pivot(arr,l,r);
            if(pos - l == k-1)
                return arr[pos];
            if (pos - l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);
 
            // Else recur for right subarray
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }
        return Integer.MAX_VALUE;
    } 
    public static int pivot(int[] arr, int l,int r ){
        int x = arr[r],i = l,temp=0;
        for(int j =l;j<r;j++){
            if(arr[j]>x){
                temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
            }
        }
        temp = arr[r];
        arr[r]=arr[i];
        arr[i]=temp;
        return i;
    }

}
