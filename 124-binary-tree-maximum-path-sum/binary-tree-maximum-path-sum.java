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
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
         int c= DFS(root );
         return maxi;
        
    }

    public int DFS(TreeNode root )
    {

        if(root==null)
        {
            return 0;
        }

        int l=Math.max(0,DFS(root.left ));
        int r=Math.max(0,DFS(root.right));
        
        maxi=Math.max(maxi,root.val+l+r);
        
        return root.val +  Math.max( r ,l) ;

    }
}