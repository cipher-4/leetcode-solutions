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
    public int widthOfBinaryTree(TreeNode root) {

        if(root == null)
        {
            return 0;
        }
        int ans =0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        while(!q.isEmpty())
        {
            int size = q.size();

            TreeNode node = q.peek().node;
            int min = q.peek().ind;

            int first=0; int last=0;

            for(int i=0; i<size; i++)
            {
                int curr_ind = q.peek().ind - min;
                TreeNode curr = q.peek().node;
                q.poll();
                
                if(i == 0)
                {
                    first = curr_ind;
                }
                if(i == size-1)
                {
                    last = curr_ind;
                }
                if(curr.left != null)
                {
                    q.add(new Pair(curr.left, 2*curr_ind+1));
                }
                if(curr.right != null)
                {
                    q.add(new Pair(curr.right, 2*curr_ind+2));
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
    }
}
class Pair
{
    TreeNode node;
    int ind;
    Pair(TreeNode node, int ind)
    {
        this.node = node;
        this.ind = ind;
    }
}