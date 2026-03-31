public class RemoveNodeFromEndOfLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        if (length == n) {
            return head.next;
        }

        curr = head;
        for (int i = 1; i < length - n; i++) {
            curr = curr.next;
        }

        return head;
    }
}