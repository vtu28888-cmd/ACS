class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: if the tree is empty, no path exists
        if (root == null) {
            return false;
        }
        
        // If it's a leaf node, check if its value matches the remaining target sum
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        
        // Recursively check the left and right subtrees with the reduced target sum
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}