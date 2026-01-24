package DataStructures.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {

   private int data;
   private Tree left;
   private Tree right;

   Tree(int val){
        this.data = val;
        this.left = null;
        this.right = null;
   }

   public void printInOrder(Tree root){
        if(root!=null){
            printInOrder(root.left);
            System.out.println(root.data+" ");
            printInOrder(root.right);
        }
   }

   public void printPreOrder(Tree root){
        if(root!=null){
            printInOrder(root.left);
            printInOrder(root.right);
            System.out.println(root.data +" ");
        }
   }

   public List<Integer> getInOrder(Tree root,List<Integer> al){
        if(root!=null){
            printInOrder(root.left);
            al.add(root.data);
            printInOrder(root.right);
        }
        return al;
   }

   public List<Integer> getPreOrder(Tree root,List<Integer> al){
        if(root!=null){
            printInOrder(root.left);
            printInOrder(root.right);
            al.add(root.data);
        }
        return al;
   }

   public int getHeightOfTree(Tree root){
        if(root==null)
            return 0;
        int left = getHeightOfTree(root.left);
        int right = getHeightOfTree(root.right);
        if(left>right)
            return left+1;
        return right +1;
   }

   public boolean isSame(Tree p,Tree q){
        if(p==null && q==null)
            return true;
        if(p==null && q!=null || p!=null && q==null)
            return false;
        if(p.data == q.data && isSame(p.left,q.left) && isSame(p.right,q.right))
            return true;
        return false;
   }

    public Tree invertTree(Tree root) {
        if(root == null)
            return null;

        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Tree node = q.poll(),left,right;
            left = node.left;
            right = node.right;

            node.left = right;
            node.right = left;

            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
        return root;
    }
    public int maxDepth(Tree root) {
        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public boolean isSubtree(Tree root, Tree subRoot) {
        if(subRoot == null)
            return true;
        if(root == null)
            return false;
        if(isSame(root,subRoot))
            return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public Tree lowestCommonAncestor(Tree root, Tree p, Tree q) {
        if(root == null || p == null || q == null)
            return null;
        if(Math.max(p.data,q.data)<root.data)
            return lowestCommonAncestor(root.left,p,q);
        if(Math.min(p.data,q.data)>root.data)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }
    public List<List<Integer>> levelOrder(Tree root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();

            for(int i=q.size();i>0;i--){
                Tree node = q.poll();
                if(node!=null){
                    level.add(node.data);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if(!level.isEmpty())
                res.add(level);
        }
        return res;
    }
    public boolean isValidBST(Tree root) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        return isValid(root,min,max);
    }
    public boolean isValid(Tree root,int min,int max){
        if(root==null)
            return true;
        if(root.data>min && root.data<max)
            return isValid(root.left,min,root.data) && isValid(root.right,root.data,max);
        return false;
    }

    public int kthSmallest(Tree root, int k) {
        List<Integer> arr = new ArrayList<Integer>();
        inOrder(root,arr);
        return arr.get(k-1);
    }
    public void inOrder(Tree root,List<Integer> arr){
        if(root == null)
            return;
        inOrder(root.left,arr);
        arr.add(root.data);
        inOrder(root.right,arr);
    }
}


