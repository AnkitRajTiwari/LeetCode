/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        makeParent(parent, root, null);
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        int curSize = 0;
        q.offer(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            if (curSize == k) {
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    q.offer(node.right);
                    visited.add(node.right);
                }
                TreeNode par = parent.get(node);
                if (par != null && !visited.contains(par)) {
                    visited.add(par);
                    q.add(par);
                }
            }
            curSize++;
        }
        List<Integer> result= new ArrayList<>();
        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
        return result;

    }

    public void makeParent(Map<TreeNode, TreeNode> parent, TreeNode node, TreeNode child) {
        if (node == null)
            return;
        parent.put(node, child);
        makeParent(parent, node.left, node);
        makeParent(parent, node.right, node);
    }
}