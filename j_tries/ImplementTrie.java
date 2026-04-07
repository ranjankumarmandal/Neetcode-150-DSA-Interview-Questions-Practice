public class ImplementTrie {
    private static class Node {
        Node[] children = new Node[26];
        boolean end;
    }

    private final Node root;

    public Trie() {
        root = new Node();
    }

}