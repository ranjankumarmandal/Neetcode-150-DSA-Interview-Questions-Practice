public class KthSmallestIntegerInBST {
    int k;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        dfs(node.left);

        k--;
        if (k == 0) {
            res = node.val;
            return;
        }

        dfs(node.right);
    }
}