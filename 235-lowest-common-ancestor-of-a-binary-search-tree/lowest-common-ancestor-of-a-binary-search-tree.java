class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while (root != null) {
            
            // Both nodes in left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // Both nodes in right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // Split point → this is LCA
            else {
                return root;
            }
        }
        
        return null;
    }
}
