package DataStructures.Trees;

public class TreeUtils {
    public static boolean isSame(Tree p, Tree q){
        if(p==null && q==null)
            return true;
        if(p==null && q!=null || p!=null && q==null)
            return false;
        if(p.data == q.data && isSame(p.left,q.left) && isSame(p.right,q.right))
            return true;
        return false;
    }
}
