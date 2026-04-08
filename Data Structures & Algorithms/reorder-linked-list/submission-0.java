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
          List<ListNode> arr = new ArrayList<>();
        ListNode curr = head.next;
        while (curr != null) {
            arr.add(curr);
            curr = curr.next;
        }

        int l = 0, r = arr.size() - 1;
        curr = head;
        while (l < r) {
            curr.next = arr.get(r--);
            curr=curr.next;
            curr.next = arr.get(l++);
            curr=curr.next;
        }
        if (l == r) {
            curr.next = arr.get(l);
            curr = curr.next;
        }
        curr.next=null;
    }
}
