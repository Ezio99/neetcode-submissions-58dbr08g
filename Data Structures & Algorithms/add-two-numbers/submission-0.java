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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumHead = new ListNode(0);
        ListNode curr1 = l1, curr2 = l2, sumNode = sumHead;
        int carry = 0;
        while (curr1 != null || curr2 != null || carry > 0) {
            int val1 = curr1 == null ? 0 : curr1.val;
            int val2 = curr2 == null ? 0 : curr2.val;
            sumNode.val = val1 + val2 + carry;
            System.out.println(sumNode.val);
            carry = sumNode.val / 10;
            sumNode.val = sumNode.val % 10;
            if (curr1 != null) {
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                curr2 = curr2.next;
            }

            if (curr1 != null || curr2 != null || carry > 0) {
                sumNode.next = new ListNode(0);
                sumNode = sumNode.next;
            }
        }

        return sumHead;
    }
}
