/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class Solution {

  public List<Integer> preorderTraversal(TreeNode root) {
    // Recursive Version
    // List<Integer> sequence = new LinkedList<Integer>();
    // preorderTraversalRecursive(sequence, root);
    // return sequence;

    // Iterative Version
    return preorderTraversalIterative(root);
  }

  public void preorderTraversalRecursive(List<Integer> sequence, TreeNode root) {
    if (root == null) {
      return;
    }

    sequence.add(root.val);
    preorderTraversalRecursive(sequence, root.left);
    preorderTraversalRecursive(sequence, root.right);
  }

  public List<Integer> preorderTraversalIterative(TreeNode root) {
    List<Integer> sequence = new LinkedList<Integer>();

    if (root == null) {
      return sequence;
    }

    Stack<TreeNode> stack = new Stack<TreeNode>();

    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode current = stack.pop();
      if (current == null) {
        continue;
      }

      sequence.add(current.val);

      stack.push(current.right);
      stack.push(current.left);
    }

    return sequence;
  }
}