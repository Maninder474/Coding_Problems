package DataStructures.Arrays;

public class ArrayUtils {
    public static int Max(int a,int b){
        if(a>b)
            return a;
        return b;
    }
    public static void swap(int a[],int i,int k){
        int temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }
}
