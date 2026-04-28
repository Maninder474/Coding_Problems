package DataStructures.Arrays;

public class KthSmallest {

    // this function returns the kth smallest element using quick sort logic
    // modify the pivot funtion to get the kth largest as will by changing the less then equal to to greaterthen sign.
    // super fast way to do it is by using random pivot
    // if want to go for fast way remove the random and just replace with the partition function.
    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        if(k>0 && k<= r-l+1){
            int pos = randomPartition(arr,l,r);
            if(pos - l == k-1)
                return arr[pos];
            if (pos - l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);

            // Else recur for right subarray
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }
        return Integer.MAX_VALUE;
    }
    public static  int randomPartition(int arr[], int l, int r)
    {
        int n = r - l + 1;
        int pivot = (int)(Math.random() * (n - 1));
        int temp = arr[l+pivot];
        arr[l+pivot] = arr[r];
        arr[r] = temp;
        return partition(arr, l, r);
    }
    public static int partition(int[] arr, int l,int r ){
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
