/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
  private String serializeNode(TreeNode node) {
    if (node == null) {
      return "null";
    }
    
    return node.val + "";
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null)
      return "";

    StringBuilder result = new StringBuilder();
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);

    while (!q.isEmpty()) {
      TreeNode current = q.poll();
      result.append(serializeNode(current) + ",");

      if (current != null) {
        q.offer(current.left);
        q.offer(current.right);
      }
    }
    
    return result.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if ("".equals(data)) {
      return null;
    }

    String[] serializedNodes = data.split(",");

    Queue<TreeNode> q = new LinkedList<TreeNode>();

    TreeNode root = deserializeNode(serializedNodes[0]);
    q.offer(root);

    int i = 1;
    while (i < serializedNodes.length) {
      TreeNode left = deserializeNode(serializedNodes[i]);
      TreeNode right = deserializeNode(serializedNodes[i + 1]);
      q.peek().left = left;
      q.peek().right = right;
      q.poll();

      if (left != null) {
        q.offer(left);
      }
      if (right != null) {
        q.offer(right);
      }

      i += 2;
    }

    return root;
  }

  public TreeNode deserializeNode(String s) {
    if ("null".equals(s))
      return null;

    return new TreeNode(Integer.parseInt(s));
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));