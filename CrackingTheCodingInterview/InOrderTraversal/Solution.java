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
    public List<Integer> inorderTraversal(TreeNode root) {
      // Recursive Solution
      List<Integer> sequence = new LinkedList<Integer>();
      inorderTraversalRecursive(sequence, root);
      return sequence;

      // Iterative Solution
      // return inorderTraversalIterative(root);
    }

    public void inorderTraversalRecursive(List<Integer> sequence, TreeNode root) {
      if (root == null) {
        return;
      }

      inorderTraversalRecursive(sequence, root.left);
      sequence.add(root.val);
      inorderTraversalRecursive(sequence, root.right);
    }

    // Another Solution: http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
    public List<Integer> inorderTraversalIterative(TreeNode root) {
      List<Integer> sequence = new LinkedList<Integer>();

      if (root == null) {
        return sequence;
      }

      Stack<TreeNode> processingRight = new Stack<TreeNode>();
      Stack<TreeNode> stack = new Stack<TreeNode>();

      stack.push(root);

      while (!stack.isEmpty()) {
        TreeNode current = stack.pop();

        if (current == null) {
          continue;
        }

        if (!processingRight.isEmpty() && processingRight.peek() == current) {
          processingRight.pop();
          sequence.add(current.val);
          stack.push(current.left);
        } else if (current.right != null) {
          processingRight.push(current);
          stack.push(current);
          stack.push(current.right);
        } else {
          sequence.add(current.val);
          stack.push(current.left);
        }
      }

      Collections.reverse(sequence);

      return sequence;
    }
}