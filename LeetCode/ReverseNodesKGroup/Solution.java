/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

  // Reverse the entire list
  // Runtime: O(n) where n is the length of the list
  public ListNode reverse(ListNode head) {
    ListNode current = head;
    ListNode previous = null;

    while (current != null) {
      ListNode next = current.next;
      current.next = previous;

      previous = current;
      current = next;
    }

    return previous;
  }

  public void printList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    System.out.println();
  }

  // Runtime: O(n) where n is the length of the list
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode current = head;
    ListNode previousTail = null;
    ListNode currentHead = head;

    int currentCount = 0;
    
    while (current != null) {
      currentCount++;
      ListNode next = current.next;

      if (currentCount == k) {
        ListNode nextHead = current.next;
        current.next = null; // cut the list so it can be reversed
        reverse(currentHead);

        // connect the reversed group back into the original list
        if (previousTail != null) {
          previousTail.next = current;
        } else {
          head = current;
        }

        currentHead.next = nextHead;

        // set up variables for the next group
        current = nextHead;
        previousTail = currentHead;
        currentHead = nextHead;
        currentCount = 0;
      } else {
        current = next;
      }
    }

    return head;
  }
}