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
class Pair{
    TreeNode node; int n;
    Pair(TreeNode node, int n){
        this.node = node;
        this.n = n;
    }
}



class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        List<int[]> ans = new ArrayList<>();
if (root == null) return list;
        q.add(new Pair(root,0));
      
        while(!q.isEmpty()){
            Pair noder = q.poll();
            ans.add(new int[]{noder.node.val,noder.n});
            if(noder.node.left != null) q.add(new Pair(noder.node.left,noder.n+1));
            if(noder.node.right != null) q.add(new Pair(noder.node.right,noder.n+1));
        }

       list.add(Arrays.asList(ans.get(0)[0]));

        for (int i = 1; i < ans.size(); ) {
            int level = ans.get(i)[1];
            List<Integer> l = new ArrayList<>();

            int j = i;
            while (j < ans.size() && ans.get(j)[1] == level) {
                l.add(ans.get(j)[0]);
                j++;
            }

            list.add(l);
            i = j;
        }


        return list;
        
    }
}
