Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,2,3]


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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        preOr(root,l);;
        return l;
    }
    void preOr(TreeNode root, List<Integer> l){
        if(root==null)
        return ;

        l.add(root.val);
        preOr(root.left,l);
        preOr(root.right,l);
    }
}
