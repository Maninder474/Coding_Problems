package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {

    // Function to find the order of characters in the alien language
    public String findOrder(String[] words) {
        // code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[26];
        boolean[] visited = new boolean[26];
        for(int i = 0;i<26;i++)
            graph.add(new ArrayList<>());
        for(String s : words)
            for(char ch : s.toCharArray())
                visited[ch-'a']=true;
        for(int i = 0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(),s2.length());
            int j =0;
            while(j<len && s1.charAt(j)==s2.charAt(j)) j++;
            if(j<len){
                int u = s1.charAt(j)-'a';
                int v = s2.charAt(j)-'a';
                graph.get(u).add(v);
                inDegree[v]++;
            }else if(s1.length()>s2.length()) return "";
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<26;i++)
            if(inDegree[i]==0 && visited[i])
                q.offer(i);

        String res = "";
        while(!q.isEmpty()){
            int u = q.poll();
            res+= (char)(u+'a');
            for(int v : graph.get(u)){
                inDegree[v]--;
                if(inDegree[v]==0)
                    q.offer(v);
            }
        }

        for(int i =0;i<26;i++)
            if(visited[i] && inDegree[i]!=0)
                return "";
        return res;
    }

}
