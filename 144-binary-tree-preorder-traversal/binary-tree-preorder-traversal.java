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
    public List<Integer> preorderTraversal(TreeNode root) {
       // first we have to store it in the variable 
       List<Integer> ans=new ArrayList<>();
       preorderhelper(root,ans);
       return ans;
    }
    public void preorderhelper(TreeNode root,List<Integer> ans)
    {
        if(root==null) return ;
        ans.add(root.val);
        preorderhelper(root.left,ans);
        preorderhelper(root.right,ans);
    }
}