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
    HashMap<Integer, Integer> valToIndex;
    int pre_idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        valToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(0, inorder.length - 1, preorder);
    }

    public TreeNode build(int left, int right, int[] preorder) {
        if (left > right) return null;
        int root_val = preorder[pre_idx++];
        TreeNode root = new TreeNode(root_val);
        int mid = valToIndex.get(root_val);
        root.left = build(left, mid - 1, preorder);
        root.right = build(mid + 1, right, preorder);
        return root;
    }
}
