/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LeastCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == p || root == q)
            return root;

        if ((root.val > p.val && root.val < q.val) || root.val < p.val && root.val > q.val ){
            return root;
        } else {
            if (p.val > root.val && q.val > root.val)
                return lowestCommonAncestor(root.right, p, q);
            else
                return lowestCommonAncestor(root.left, p, q);
        }
    }
}