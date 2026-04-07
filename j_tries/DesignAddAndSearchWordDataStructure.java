public class DesignAddAndSearchWordDataStructure {
    private static class Node {
        Node[] children = new Node[26];
        boolean end;
    }

    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) cur.children[i] = new Node();
            cur = cur.children[i];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, Node node) {
        if (node == null) return false;
        if (idx == word.length()) return node.end;

        char c = word.charAt(idx);

        if (c == '.') {
            for (Node child : node.children) {
                if (child != null && dfs(word, idx + 1, child)) return true;
            }
            return false;
        } else {
            return dfs(word, idx + 1, node.children[c - 'a']);
        }
    }
}