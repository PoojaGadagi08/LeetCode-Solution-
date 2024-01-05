Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 

Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105
 

Follow up: Could you solve it with time complexity O(height of tree)?




  // /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {

//     public TreeNode helper(TreeNode root){
//         if(root.left == null){
//         return root.right;
//         }
//         else if(root.right == null)
//         return root.left;
//         else{
//         TreeNode rightChild=  root.right;
//         TreeNode lastChild = findLastChild(root.left);
//         lastChild.right = rightChild;

//         return root.left;
//         }
//     }

//     public TreeNode findLastChild(TreeNode root){
//         if(root.left == null)
//         return root;

//         return findLastChild(root.left);
//     }
//     public TreeNode deleteNode(TreeNode root, int key) {
//         if(root  ==  null){
//             return null;
//         }

//         if(root.val == key)
//         return helper(root);

//         TreeNode dummy = root;

//         while(root != null){
//             if(root.val > key){
//                 if(root.left != null && root.left.val == key){
//                 root.left = helper(root.left);
//                 break;
//                 }
//             else 
//             root=root.left;
//             }
//             else {
//                 if(root.right != null && root.right.val == key){
//                 root.right = helper(root.left);
//                 break;
//                 }
//             else 
//             root=root.right; 
//             }
//         }
//         return dummy;
//     }
// }




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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        // Base case: if the root is null, the key is not found in the tree
        if(root == null){
            return root;
        }
    
        // Recursively search for the key in the left subtree if it is less than the root value
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }

        // Recursively search for the key in the right subtree if it is greater than the root value
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }

        // If the key is equal to the root value, we have found the node to be deleted
        else{

            // Case 1: If the node has no children, we simply set the root to null
            if(root.left == null && root.right == null){
                root = null;
            }

            // Case 2: If the node has only one child, we replace the root with the child
            else if(root.left == null){
                root = root.right;
            }

            else if(root.right == null){
                root = root.left;
            }
            
            // Case 3: If the node has two children, we find the inorder successor of the node, 
            // which is the node with the smallest value in the right subtree. We then replace 
            // the value of the root with the value of the inorder successor, and recursively 
            // delete the inorder successor node from the right subtree.
            else{
                TreeNode successor = findMin(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }
        }
        // Return the updated root of the subtree
        return root;
    }

    // Helper method to find the node with the minimum value in the subtree rooted at "node"
    private TreeNode findMin(TreeNode node){
        
        // Traverse down the left subtree until we reach a leaf node with no left child
        while(node.left != null){
            node = node.left;
        }
        // Return the node with the smallest value in the subtree
        return node;
    }
}
