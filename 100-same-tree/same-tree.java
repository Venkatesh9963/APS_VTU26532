class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, trees are same
        if (p == null && q == null) {
            return true;
        }
        
        // If one is null and other is not, trees are not same
        if (p == null || q == null) {
            return false;
        }
        
        // Check current node value and recursively check left & right
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && 
                   isSameTree(p.right, q.right);
        }
        
        return false;
    }
}
