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

    }
}