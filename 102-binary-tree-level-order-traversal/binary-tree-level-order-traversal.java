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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // step are 1) first take a queue 2) push the root into the queue 3) then put a while  loop into the queue and traverse the left and then the right 
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans=new ArrayList<>(); // final list 
        Queue<TreeNode> q=new LinkedList<>(); // fifo 
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> ll=new ArrayList<>(); // inside final list
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode node=q.poll(); // remove the current node 
                ll.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            ans.add(ll);
        }
       return ans;
    }
}