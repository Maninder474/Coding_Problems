package DataStructures.Trees;

import java.util.List;

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
}


