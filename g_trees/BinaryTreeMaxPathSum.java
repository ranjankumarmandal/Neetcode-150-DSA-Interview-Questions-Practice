public class BinaryTreeMaxPathSum {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        res = Math.max(res, node.val + left + right);

        return node.val + Math.max(left, right);
    }
}