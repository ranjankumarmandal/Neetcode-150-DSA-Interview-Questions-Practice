public class MergeKSortedLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a, b) -> a.val - b.val
        );

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        return dummy.next;
    }
}