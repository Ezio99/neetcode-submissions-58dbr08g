/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        preorder(root,k,maxHeap);
        
        return maxHeap.poll();


    }

    public void preorder(TreeNode node, int k, PriorityQueue<Integer> maxHeap) {
        if(node==null){
            return; 
        }
        
        preorder(node.left,k,maxHeap);
        maxHeap.offer(node.val);
        if(maxHeap.size()>k){
            maxHeap.poll();
        }
        preorder(node.right,k,maxHeap);
        
    }
}
