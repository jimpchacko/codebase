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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        if(t1==null && t2==null)
            return null;
        if(t1==null)
            return t2;
        Stack<TreeNode[]> tuple = new Stack<>();
        tuple.push(new TreeNode[]{t1, t2});
        
        while(!tuple.isEmpty()){
            TreeNode[] pair = tuple.pop();
            if(pair[0] == null || pair[1] == null)
                continue;
            pair[0].val += pair[1].val;            
            if(pair[0].left == null)
                pair[0].left = pair[1].left;
            else
                tuple.push(new TreeNode[]{pair[0].left, pair[1].left});
            
            if(pair[0].right == null)
                pair[0].right = pair[1].right;
            else
                tuple.push(new TreeNode[]{pair[0].right, pair[1].right});
            
        }
        return t1;
    }
}
