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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // traverse through the levelorder and then reverse alternate 
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>(); 
        if(root==null){
            return ans;
        }
        q.add(root);
        int level=0; // for reversing by using mod 2
        while(!q.isEmpty()){
            int size=q.size();
            level++;
            List<Integer> currentlevel=new ArrayList<>();  // make smalllist 
            while(size-->0){
                TreeNode curr=q.poll();
                currentlevel.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(level%2==0){
                Collections.reverse(currentlevel);
            }
         ans.add(currentlevel);
        }
        return ans;
    }
}