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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        return helper(root,1)!=-10;



    }

    public int helper(TreeNode node,int currDepth){
        if(node==null){
            return currDepth-1;
        }
        if(node.left==null && node.right==null){
            return currDepth;
        }

        int l,r;
        l = helper(node.left,currDepth+1);
        r = helper(node.right,currDepth+1);

        if(l==-10||r==-10){
            return -10;
        }

        if(Math.abs(l-r)>1){
            return -10;
        }


        return Math.max(l,r);

    }
}
