/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    // count n nodes from head
    ListNode current = head;
    int count = 1;

    while (current != null && count < n) {
      count++;
      current = current.next;
    }

    ListNode nNodesAfter = current;

    // loop through the list from start and stop when nNodesAfter is the tail
    current = head;
    ListNode previous = null;

    while (nNodesAfter.next != null) {
      previous = current;
      current = current.next;
      nNodesAfter = nNodesAfter.next;
    }

    if (previous == null) {
      // the node to remove is the head
      head = head.next;
    } else {
      previous.next = current.next;
    }

    return head;
  }
}