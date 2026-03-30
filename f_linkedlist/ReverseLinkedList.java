public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, next;

        while(curr != null) {
            next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

    }
}