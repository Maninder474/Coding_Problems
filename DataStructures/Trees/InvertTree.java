package DataStructures.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
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
}
