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
  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d == 1) {
      TreeNode newRoot = new TreeNode(v);
      newRoot.left = root;
      return newRoot;
    }

    if (root == null) {
      return null;
    }

    if (d == 2) {
      TreeNode newLeft = new TreeNode(v);
      TreeNode newRight = new TreeNode(v);
      newLeft.left = root.left;
      newRight.right = root.right;
      root.left = newLeft;
      root.right = newRight;
      return root;
    }

    root.left = addOneRow(root.left, v, d - 1);
    root.right = addOneRow(root.right, v, d - 1);

    return root;
  }
}