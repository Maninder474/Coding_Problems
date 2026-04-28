package DataStructures.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];
        int n = nums.length;
        int prod = 1;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
                if(j!=i)
                    prod*=nums[j];
            res[i]=prod;
            prod = 1;
        }
        return res;
    }

    public static int[] productExceptSelfMedium(int[] nums) {
        int prod = 1, zeroCount = 0;
        for(int n:nums)
            if(n!=0)
                prod*=n;
            else
                zeroCount++;
        if(zeroCount > 1)
            return new int[nums.length];

        int [] res = new int[nums.length];

        for(int i = 0; i<nums.length;i++)
            if(zeroCount >0)
                res[i] = (nums[i]==0) ? prod:0;
            else
                res[i] = prod/nums[i];
        return res;
    }
}
