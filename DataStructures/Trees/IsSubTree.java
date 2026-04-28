package DataStructures.Trees;

public class IsSubTree {
    public boolean isSubtree(Tree root, Tree subRoot) {
        if(subRoot == null)
            return true;
        if(root == null)
            return false;
        if(TreeUtils.isSame(root,subRoot))
            return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}
