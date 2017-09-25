public class Solution {
  // Runtime: O(nlogn)
  public boolean checkBST(Node root) {
    if (root == null) {
      return true;
    }

    if (checkBST(root.left) && checkBST(root.right)) {
      return getMin(root.right) > root.data && getMax(root.left) < root.data;
    }

    return false;
  }

  // Runtime: O(logn)
  public int getMax(Node root) {
    if (root == null) {
      return -1;
    }

    if (root.right != null) {
      return getMax(root.right);
    }
    return root.data;
  }

  // Runtime: O(logn)
  public int getMin(Node root) {
    if (root == null) {
      return 10000;
    }

    if (root.left != null) {
      return getMin(root.left);
    }

    return root.data;
  }
}

class Node {
  int data;
  Node left;
  Node right;
}