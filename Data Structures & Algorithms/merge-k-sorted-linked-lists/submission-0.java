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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }

        //Put minimum list in pos 0
        ListNode minNode = lists[0], tmp;
        int pos = 0;
        for (int i = 1; i < lists.length; i++) {
            if (lists[i].val < minNode.val) {
                minNode = lists[i];
                pos = i;
            }
        }

        if (minNode != lists[0]) {
            tmp = lists[pos];
            lists[pos] = lists[0];
            lists[0] = tmp;
        }
        ListNode head = lists[0];
        minNode = lists[0];
        lists[0] = lists[0].next;

        ListNode currMinNode = null;
        int currMinValue = 0;
        while (true) {
            currMinValue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < currMinValue) {
                    currMinNode = lists[i];
                    currMinValue = currMinNode.val;
                    pos = i;
                }
            }
            if (currMinValue == Integer.MAX_VALUE) {
                break;
            }
            minNode.next = currMinNode;
            minNode = currMinNode;
            lists[pos] = lists[pos].next;
        }

        return head;
    }
}
