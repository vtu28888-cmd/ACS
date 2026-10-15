class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            dfs(root, "", result);
        }
        return result;
    }
    
    private void dfs(TreeNode node, String currentPath, List<String> result) {
        // If it's a leaf node, append the final value and add to result
        if (node.left == null && node.right == null) {
            result.add(currentPath + node.val);
            return;
        }
        
        // Otherwise, continue building the path
        currentPath += node.val + "->";
        
        if (node.left != null) {
            dfs(node.left, currentPath, result);
        }
        if (node.right != null) {
            dfs(node.right, currentPath, result);
        }
    }
}