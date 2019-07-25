/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int min = Integer.MAX_VALUE;
    private int lastValue = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if(root == null)
            return Integer.MAX_VALUE;
        minDiffInBST(root.left);
        if(lastValue != Integer.MAX_VALUE)
            min = Math.min(min, root.val - lastValue);
        lastValue = root.val;

        minDiffInBST(root.right);
        
        return min;
    }
}
