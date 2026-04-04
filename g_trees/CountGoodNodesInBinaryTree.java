public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) return 0;

        int res = node.val >= max ? 1 : 0;
        int newMax = Math.max(max, node.val);

        res += dfs(node.left, newMax);
        res += dfs(node.right, newMax);

        return res;
    }
}