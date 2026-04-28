package DataStructures.Arrays;

import java.util.Stack;

public class MaxArea {

    public static int getMaxArea(int arr[]) {

        int n = arr.length,curr = 0,tp=0,res=0;
        Stack<Integer> st = new Stack<>();

        for(int i =0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                tp = st.pop();
                int width = st.isEmpty() ? i:i-st.peek()-1;
                res = Math.max(res,arr[tp]*width);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            tp = st.pop();
            curr = arr[tp]*(st.isEmpty() ? n:n-st.peek()-1);
            res = Math.max(res,curr);
        }
        return res;

    }
}
