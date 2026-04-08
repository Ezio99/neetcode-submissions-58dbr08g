/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> oldToNewNode = new HashMap<>();
        Node newHead = new Node(head.val);
        newHead.random = head.random;
        oldToNewNode.put(head, newHead);
        Node curr = head, newCurr = newHead;
        while (curr.next != null) {
            curr = curr.next;
            newCurr.next = new Node(curr.val);
            newCurr = newCurr.next;
            newCurr.random = curr.random;
            oldToNewNode.put(curr, newCurr);
        }

        newCurr = newHead;
        while (newCurr != null) {
            if (newCurr.random != null) newCurr.random = oldToNewNode.get(newCurr.random);
            newCurr = newCurr.next;
        }

        return newHead;


    }
}
