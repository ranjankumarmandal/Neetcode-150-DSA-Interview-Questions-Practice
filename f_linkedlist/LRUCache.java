public class LRUCache {
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();

        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (this.map.containsKey(key) == false) {
            return -1;
        }

        Node node = this.map.get(key);
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (this.capacity == 0) {
            return;
        }

        if (this.map.containsKey(key) == true) {
            Node node = this.map.get(key);
            node.value = value;
            moveToFront(node);
            return;
        }

        Node newNode = new Node(key, value);
        this.map.put(key, newNode);
        addToFront(newNode);

        if (this.map.size() > this.capacity) {
            Node lru = this.tail.prev;
            remove(lru);
            this.map.remove(lru.key);
        }
    }

    private void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }

    private void addToFront(Node node) {
        Node first = this.head.next;
        node.prev = this.head;
        node.next = first;
        this.head.next = node;
        first.prev = node;
    }

    private void remove(Node node) {
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;
        node.prev = null;
        node.next = null;
    }
}