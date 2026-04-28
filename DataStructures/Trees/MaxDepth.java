package DataStructures.Trees;

public class MaxDepth {
    public int maxDepth(Tree root) {
        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
