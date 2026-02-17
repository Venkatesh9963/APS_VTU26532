class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        while (true) {
            
            // Go to leftmost node
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            k--;
            
            // If kth element found
            if (k == 0) {
                return root.val;
            }
            
            root = root.right;
        }
    }
}
