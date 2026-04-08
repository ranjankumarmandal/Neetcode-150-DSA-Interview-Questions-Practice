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


    }
}