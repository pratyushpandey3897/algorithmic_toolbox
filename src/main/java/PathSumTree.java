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
class PathSumTree {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if (root == null)
            return false;
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null)
            return true;
        else {
            return (hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum));
        }
    }
        
}
