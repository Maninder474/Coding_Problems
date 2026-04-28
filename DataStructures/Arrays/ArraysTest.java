package DataStructures.Arrays;


import DataStructures.util.time.Clock;

public class ArraysTest {

    static int arr[] = {1,1,1,2,2,3,3,3,3,4,5,5,5,5,5,6,7,8,8,9,9,9,9,9,9};
    public static void topKFrequent(Clock clock) {
        clock.start();
        int [] res3 = TopKFrequent.topKFrequent(arr, 3);
        clock.stop();
        for(int n : res3)
            System.out.print(n+" ");
        System.out.println();
        System.out.println("Time taken : " + clock.getTotalTime() + " ms");
    }
    public static void productExceptSelf(Clock clock) {
        clock.start();
        int [] res6 = ProductExceptSelf.productExceptSelf(arr);
        clock.stop();
        for(int n : res6)
            System.out.print(n+" ");
        System.out.println();
        System.out.println("Time taken : " + clock.getTotalTime() + " ms");
    }
    public static void productExceptSelfMedium(Clock clock) {
        clock.start();
        int [] res6 = ProductExceptSelf.productExceptSelfMedium(arr);
        clock.stop();
        for(int n : res6)
            System.out.print(n+" ");
        System.out.println();
        System.out.println("Time taken : " + clock.getTotalTime() + " ms");
    }
    public static void kthSmallestInteger() {
        int arr[] = { 1, 2, 3, 4 };
        Clock clock = new Clock();
        clock.start();
        System.out.println(KthSmallest.kthSmallest(arr, 0, 3, 4));
        clock.stop();
        System.out.println("Time taken : " + clock.getTotalTime() + " ms");
    }
}
