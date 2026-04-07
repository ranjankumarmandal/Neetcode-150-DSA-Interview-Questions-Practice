public class DesignAddAndSearchWordDataStructure {
    private static class Node {
        Node[] children = new Node[26];
        boolean end;
    }

    private final Node root;

    public WordDictionary() {
        root = new Node();
    }
}