package DataStructures.Arrays;

public class MajorElement {

    public static void findMajorEle(int arr[]){
        int cad = getCandidate(arr);
        if(isMajorEle(arr,cad))
            System.out.println(cad);
        else
            System.out.println("No Major element");
    }
    public static boolean isMajorEle(int a[],int cad){
        int n = a.length,count=0;
        for(int i = 0;i<n;i++)
            if(a[i]==cad)
                count++;
        if(count>n/2)
            return true;
        else
            return false;
    }

    public static int getCandidate(int a[]){
        int majEleInd = 0,count = 1;
        int n = a.length;
        for(int i = 1;i<n;i++){
            if(a[i]==a[majEleInd])
                count++;
            else
                count--;
            if(count==0){
                majEleInd = i;
                count = 1;
            }
        }
        return a[majEleInd];
    }
}
