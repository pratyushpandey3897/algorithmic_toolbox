import java.util.HashSet;
import java.util.Set;

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
public class TwoSumBST {
    public boolean findTarget(TreeNode root, int k) {

        Set<Integer> set = new HashSet<> ();

        return targetSum(root, set, k);

    }

    public Boolean targetSum(TreeNode node, Set<Integer> set, int k){


        if (node == null)
            return false;
        int secondNum = k - node.val;


        if (set.contains(secondNum)){
            return true;
        } else {
            set.add(node.val);
            return targetSum(node.left, set, k) || targetSum(node.right, set, k);

        }


    }
}