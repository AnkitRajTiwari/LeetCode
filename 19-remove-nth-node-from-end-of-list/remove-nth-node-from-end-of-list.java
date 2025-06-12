class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;  // remove the head node
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the nth node from end
        slow.next = slow.next.next;

        return head;
    }
}


