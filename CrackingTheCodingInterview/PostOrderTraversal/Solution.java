import java.util.*;

public class Solution {

  public List<Integer> postorderTraversal(TreeNode root) {
    // Recursive Version
    // List<Integer> sequence = new LinkedList<Integer>();
    // postorderTraversalRecursive(sequence, root);
    // return sequence;

    // Iterative Version
    return postorderTraversalIterative(root);
  }

  public void postorderTraversalRecursive(List<Integer> sequence, TreeNode root) {
    if (root == null) {
      return;
    }

    postorderTraversalRecursive(sequence, root.left);
    postorderTraversalRecursive(sequence, root.right);
    sequence.add(root.val);
  }

  public List<Integer> postorderTraversalIterative(TreeNode root) {
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

      stack.push(current.left);
      stack.push(current.right);
    }

    Collections.reverse(sequence);
    return sequence;
  }
}