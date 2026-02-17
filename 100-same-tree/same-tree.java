class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // If both are null → same
        if(p == null && q == null) {
            return true;
        }
        
        // If one is null → not same
        if(p == null || q == null) {
            return false;
        }
        
        // If values different → not same
        if(p.val != q.val) {
            return false;
        }
        
        // Check left and right subtree
        return isSameTree(p.left, q.left) && 
               isSameTree(p.right, q.right);
    }
}
