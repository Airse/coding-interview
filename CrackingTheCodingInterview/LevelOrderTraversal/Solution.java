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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();

      if (root == null) {
        return result;
      }

      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      Queue<Integer> levelQueue = new LinkedList<Integer>();
      queue.offer(root);
      levelQueue.offer(0);

      while (!queue.isEmpty()) {
        TreeNode currentNode = queue.poll();
        int currentLevel = levelQueue.poll();

        if (currentLevel >= result.size()) {
          List<Integer> newLevel = new ArrayList<Integer>();
          newLevel.add(currentNode.val);
          result.add(newLevel);
        } else {
          result.get(currentLevel).add(currentNode.val);
        }

        if (currentNode.left != null) {
          queue.offer(currentNode.left);
          levelQueue.offer(currentLevel + 1);
        }

        if (currentNode.right != null) {
          queue.offer(currentNode.right);
          levelQueue.offer(currentLevel + 1);
        }
      }

      return result;
    }
}