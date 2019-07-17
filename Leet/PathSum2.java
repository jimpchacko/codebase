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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        findPaths(root, sum, paths, new Stack<Integer>());
        return paths;
    }
    
    private void findPaths(TreeNode root, int sum, List<List<Integer>> paths, Stack<Integer> subList){
        
        if(root == null)
            return;
        subList.add(root.val);        
        
        if(root.val == sum && isLeaf(root)){
            paths.add(new ArrayList(subList));
            subList.pop();
            return;
        }

        if(root.left!=null)
            findPaths(root.left, sum - root.val, paths, subList);
        if(root.right!=null)
            findPaths(root.right, sum - root.val, paths, subList);
        subList.pop();
        return;
    }
    
    private boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
}
