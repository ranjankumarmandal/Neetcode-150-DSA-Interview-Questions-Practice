public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int preIdx = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right) return null;

        int val = preorder[preIdx++];
        TreeNode root = new TreeNode(val);

        int mid = map.get(val);

        root.left = dfs(preorder, left, mid - 1);
        root.right = dfs(preorder, mid + 1, right);

        return root;
    }
}