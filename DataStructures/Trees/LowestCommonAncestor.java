package DataStructures.Trees;

public class LowestCommonAncestor {
    public Tree lowestCommonAncestor(Tree root, Tree p, Tree q) {
        if(root == null || p == null || q == null)
            return null;
        if(Math.max(p.data,q.data)<root.data)
            return lowestCommonAncestor(root.left,p,q);
        if(Math.min(p.data,q.data)>root.data)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}
