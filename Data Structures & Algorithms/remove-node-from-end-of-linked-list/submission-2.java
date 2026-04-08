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
   ListNode globalHead;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        globalHead = head;
        recurse(head, n);
        return globalHead;
    }

    public int recurse(ListNode node, int n) {
        if (node.next == null) {
            if (node == globalHead) {
                globalHead = globalHead.next;
            }
            return 0;
        }

        int x = 1 + recurse(node.next, n);

        if (x == n) {
            ListNode curr = node;
            ListNode tmp = curr.next;
            curr.next = tmp.next;
            tmp.next = null;
        } else if (x == n - 1 && node == globalHead) {
            globalHead = globalHead.next;
        }

        return x;

    }
}
