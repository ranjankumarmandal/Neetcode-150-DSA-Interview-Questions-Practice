public class WordSearch2 {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int wordIndex = -1;
    }

    private List<String> res = new ArrayList<>();
    private String[] words;
    private int rows, cols;

    public List<String> findWords(char[][] board, String[] words) {
        this.words = words;
        rows = board.length;
        cols = board[0].length;

        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            insert(root, words[i], i);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root);
            }
        }

        return res;
    }

    private void insert(TrieNode root, String word, int index) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.wordIndex = index;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {
        if (r < 0 || c < 0 || r >= rows || c >= cols) return;

        char ch = board[r][c];
        if (ch == '#' || node.children[ch - 'a'] == null) return;

        node = node.children[ch - 'a'];

        if (node.wordIndex != -1) {
            res.add(words[node.wordIndex]);
            node.wordIndex = -1;
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, node);
        dfs(board, r - 1, c, node);
        dfs(board, r, c + 1, node);
        dfs(board, r, c - 1, node);

        board[r][c] = ch;

        if (isEmpty(node)) {
            TrieNode parent = node;
        }
    }

}