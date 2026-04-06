class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0 ; i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> map){
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inRoot = map.get(preorder[preStart]);
        int numLeft = inRoot - inStart;

        root.left =  build(preorder, preStart + 1 , preStart + numLeft, inorder, inStart, inRoot-1, map);
        root.right = build(preorder, preStart + numLeft + 1 , preEnd , inorder, inRoot + 1 , inEnd, map);

        return root;
    }
}
