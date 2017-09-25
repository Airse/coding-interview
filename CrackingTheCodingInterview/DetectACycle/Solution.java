// Runtime: O(n)
public class Solution {
  public boolean hasCycle(Node head) {
    // Tortoise and Hare Algorithm
    Node tortoise = head;
    Node hare = head;

    while (tortoise != null && hare != null) {
      tortoise = tortoise.next;
      if (hare.next == null) {
        return false;
      }
      hare = hare.next.next;

      if (tortoise == hare) {
        return true;
      }
    }

    return false;
  }
}

class Node {
  int data;
  Node next;
}