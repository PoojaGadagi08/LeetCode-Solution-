Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.





class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildUtil(inorder, postorder, 0, inorder.length - 1, 0, postorder.length- 1);
    }

    TreeNode buildUtil(int in[], int post[], int inStrt,
                   int inEnd, int postStrt, int postEnd)
    {
        // Base case
        if (inStrt > inEnd)
            return null;
 
        /* Pick current node from Postorder traversal using
           postIndex and decrement postIndex */
        TreeNode node = new TreeNode(post[postEnd]);
 
        /* If this node has no children then return */
        if (inStrt == inEnd)
            return node;
        int iIndex = search(in, inStrt, inEnd, node.val);
 
        /* Using index in Inorder traversal, construct left
           and right subtrees */
        node.left = buildUtil(in, post, inStrt, iIndex - 1, postStrt,
                            postStrt - inStrt + iIndex - 1);

        node.right = buildUtil(in, post, iIndex + 1, inEnd,
                               postEnd - inEnd + iIndex,
                               postEnd - 1);
 
        return node;
    }
 
    /* Function to find index of value in arr[start...end]
       The function assumes that value is postsent in in[]
     */
    int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                break;
        }
        return i;
    }
 
}
