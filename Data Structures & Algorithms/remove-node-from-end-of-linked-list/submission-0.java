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
        int ctr = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            ctr++;
        }
        int removalIndex = ctr - n;

        if (removalIndex == 0) {
            return head.next;
        }
        curr = head;
        for (int i = 0; i < removalIndex - 1; i++) {
            curr = curr.next;
        }
        ListNode tmp = curr.next;
        curr.next = tmp.next;
        tmp.next=null;
        
        return head;

    }
}
