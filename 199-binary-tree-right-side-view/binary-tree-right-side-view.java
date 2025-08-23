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
    public List<Integer> rightSideView(TreeNode root) {
        // using the bfs or level order traversal
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if(root==null) return ans;

        q.add(root);

        while(!q.isEmpty()){

            int levelsize=q.size();

            for(int i=0;i<levelsize;i++){

                TreeNode curr=q.poll();

                if(i==levelsize-1){ // check if it is the last node at the current levelsize
                    ans.add(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return ans;
    }
}