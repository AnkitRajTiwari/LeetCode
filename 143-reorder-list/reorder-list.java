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
    public void reorderList(ListNode head) {
       /// solve using list 
       List<ListNode> list=new ArrayList<>();
       ListNode temp=head;
       while(temp!=null){
        list.add(temp);
        temp=temp.next;
       }

       /// two pointers 

       int start=0;
       int end=list.size()-1;
       while(start<end)
       {
        list.get(start).next=list.get(end);//// since list containds three things 
        // 1) index 2)value 3) next node example node 1 contains next node node 2 so here we are changing the next nod eof node 1 to node 5 
        start++;
        if(start==end)
        {
            break;
        }
        list.get(end).next=list.get(start);
        end--;
       }
       list.get(start).next=null;
    }
}