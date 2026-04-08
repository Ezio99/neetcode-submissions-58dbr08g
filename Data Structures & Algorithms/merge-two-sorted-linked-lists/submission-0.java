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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
                if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list2.val < list1.val) {
            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        ListNode newHead = list1;

        while (list1 != null && list2 != null) {
            ListNode prev = null;

            while (list1 != null && list1.val <= list2.val) {
                prev = list1;
                list1 = list1.next;
            }

            prev.next = list2;

            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;

        }
        
        return newHead;
    }
}