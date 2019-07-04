/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode start=head, end=head;
        if(head.next == null)
            return null;
        int distance = 0;
        while(distance<n-1){
            if(end!=null)
                end = end.next;
                
            distance++;
        }
        // System.out.println("END " + distance);
        ListNode temp = start;
        while(end.next!=null){
            temp = start;
            start = start.next;
            end = end.next;
        }
        if(start == end){
            temp.next = null;
            return head;
        }
        if(head == start){
            head = head.next;
            return head;
        }
        temp.next = temp.next.next;
        
        return head;
    }
}
