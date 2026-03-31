public class ReorderLinkedList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            return;
        }

        int left = 0;
        int right = nodes.size() - 1;

        ListNode tail = null;

        while (left <= right) {
            if (tail == null) {
                tail = nodes.get(left);
            } else {
                tail.next = nodes.get(left);
            }
            left = left + 1;

            if (left > right) {
                break;
            }

            tail.next = nodes.get(right);
            tail = tail.next;
            right = right - 1;
        }

        tail.next = null;
    }
}