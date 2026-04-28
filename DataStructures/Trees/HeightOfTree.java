package DataStructures.Trees;

public class HeightOfTree {
    public int getHeightOfTree(Tree root){
        if(root==null)
            return 0;
        int left = getHeightOfTree(root.left);
        int right = getHeightOfTree(root.right);
        if(left>right)
            return left+1;
        return right +1;
    }
}
