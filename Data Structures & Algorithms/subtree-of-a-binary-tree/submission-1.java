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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            
            if(isSameTree(node,subRoot)) return true;

            if(node.left!=null)
            q.add(node.left);
            if(node.right!=null)
            q.add(node.right);
        }


        return false;
    }
        public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        if(p==null || q==null) return false;

        if(p.val == q.val){
            if(isSameTree(p.left,q.left) && isSameTree(p.right,q.right)) return true;

            return false;
        }

        return false;
    }
}
