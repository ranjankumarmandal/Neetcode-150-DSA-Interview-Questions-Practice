public class SerializeAndDeserialzeBinaryTree {
    private int idx;

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        idx = 0;
        return dfsDeserialize(vals);
    }

    private TreeNode dfsDeserialize(String[] vals) {
        if (vals[idx].equals("N")) {
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[idx++]));
        node.left = dfsDeserialize(vals);
        node.right = dfsDeserialize(vals);
        return node;
    }
}