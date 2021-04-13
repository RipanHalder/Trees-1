/*

Thought Process: Mark a prev everytime we visit a node. By inorder travesal check the current node with prev.

T.C -> O(N)
S.C -> O(1)

*/

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
    public boolean isValidBST(TreeNode root) {
        
        // Mistake Commited - > Used wrong ranges like Integer.MIN_VALUE or Double.MIN_VALUE. It goes out of bound for the -ve last element
        double prev = -Double.MAX_VALUE;
        Stack<TreeNode> s = new Stack<>();
        
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev >= root.val) return false;
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}