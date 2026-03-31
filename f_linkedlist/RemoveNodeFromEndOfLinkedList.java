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


        return head;
    }
}