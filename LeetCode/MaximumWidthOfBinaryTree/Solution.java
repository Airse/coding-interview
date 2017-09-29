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
  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    Queue<Integer> idQueue = new LinkedList<Integer>();
    Queue<Integer> levelQueue = new LinkedList<Integer>();

    nodeQueue.offer(root);
    idQueue.offer(1);
    levelQueue.offer(1);

    int maxWidth = 0;

    int currentLevel = 0;
    int currentLevelStart = 0;
    int currentLevelEnd = 0;

    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.poll();
      int id = idQueue.poll();
      int level = levelQueue.poll();

      if (node.left != null) {
        nodeQueue.offer(node.left);
        idQueue.offer(id * 2);
        levelQueue.offer(level + 1);
      }

      if (node.right != null) {
        nodeQueue.offer(node.right);
        idQueue.offer((id * 2 ) + 1);
        levelQueue.offer(level + 1);
      }

      if (level != currentLevel) {
        currentLevelStart = id;
        currentLevelEnd = id;
        currentLevel = level;
      } else {
        currentLevelEnd = id;
      }

      maxWidth = Math.max(maxWidth, currentLevelEnd - currentLevelStart + 1);
    }

    return maxWidth;
  }
}