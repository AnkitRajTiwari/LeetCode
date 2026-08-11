/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /// handle single node linked list 
        if(head.next==null) return null;

         //// assign fast and slow pointers 
         ListNode slow=head;
         ListNode fast=head;

         // move the fast n times to create a gap 
         int i=1;
         while(i<=n)
         {
            fast=fast.next;
            i++;
         }

         // if fast becomes nunll means we have to remove the head 
         if(fast == null) return head.next;
         
         // move both until the fast point to the end of the node 
         while(fast.next!=null)
         {
            slow=slow.next;
            fast=fast.next;
         }

         //// remove the nth node 

         if(slow.next!=null)
         {
            slow.next=slow.next.next;
         }
         return head;
    }
}