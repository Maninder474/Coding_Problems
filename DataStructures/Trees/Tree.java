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
}


