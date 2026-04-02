public class DiameterOfBinaryTree {
    pint diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }
}