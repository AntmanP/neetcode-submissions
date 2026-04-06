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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode l) {
        HashSet<TreeNode> set = new HashSet<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            set.add(node);

            if(node.val == p.val)
                break;

            else if(node.val > p.val){
                if(node.left!=null)
                    q.add(node.left);
            }
            
            else if(node.val < p.val){   
                if(node.right!=null)
                    q.add(node.right);
            }        
        }

        // while(!q.isEmpty()) q.remove();
        q.add(root);
        TreeNode res = new TreeNode(Integer.MAX_VALUE);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(set.contains(node)){
                    res = node;
            }
            if(node.val == l.val)
                break;

            else if(node.val > l.val){
                if(node.left!=null)
                    q.add(node.left);
            }
            
            else if(node.val < l.val){   
                if(node.right!=null){
                    q.add(node.right);
                }
            }  
        }

        return res;

    }
}
