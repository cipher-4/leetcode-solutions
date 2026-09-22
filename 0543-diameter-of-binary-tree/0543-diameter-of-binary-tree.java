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
    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null)
        {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int lh = height(root.left);
        int rh = height(root.right);
        int d = lh+rh;

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        max = Math.max(left,right);

        return Math.max(max,d);
        
    }
    static int height(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return 1 + Math.max(lh,rh);
    }
}