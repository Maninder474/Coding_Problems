package DataStructures.Arrays;

public class Sort012 {
    // Sorts 0,1 and 2 in a array in O(N)
    public static void sort012(int a[], int n)
    {
        int l = 0 , m = n-1 ,i=0;
        while(i<=m && m>l){
            if(a[i]==0){
                ArrayUtils.swap(a,i,l);
                l++;
                i++;
            }
            else if(a[i]==2){
                ArrayUtils.swap(a,i,m);
                m--;
            }else{
                i++;
            }
        }
    }
}
