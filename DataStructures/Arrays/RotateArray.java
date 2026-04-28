package DataStructures.Arrays;

public class RotateArray {
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
                for(int j = 1;j<n;j++)
                    arr[j-1]=arr[j];
                arr[n-1]=temp;
            }
        }else{
            for(int i = 0;i<n-d;i++){
                temp = arr[n-1];
                for(int j = n-2;j>=0;j--)
                    arr[j+1]=arr[j];
                arr[0]=temp;
            }
        }
    }
}
