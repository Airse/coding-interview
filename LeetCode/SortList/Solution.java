/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  // Worst case: O(n^2)
  public NodeLinkedList quickSort(ListNode head) {
    if (head == null) {
      return new NodeLinkedList();
    }

    ListNode partition = head;
    NodeLinkedList left = new NodeLinkedList();
    NodeLinkedList right = new NodeLinkedList();

    ListNode current = head.next;
    while (current != null) {
      if (current.val < partition.val) {
        left.addNode(current);
      } else {
        right.addNode(current);
      }
      current = current.next;
    }

    NodeLinkedList result = new NodeLinkedList();

    if (left.head != null) {
      left.tail.next = null;
      NodeLinkedList sortedLeft = quickSort(left.head);
      result.head = sortedLeft.head;
      sortedLeft.tail.next = partition;
    } else {
      result.head = partition;
    }

    if (right.head != null) {
      right.tail.next = null;
      NodeLinkedList sortedRight = quickSort(right.head);
      partition.next = sortedRight.head;
      result.tail = sortedRight.tail;
    } else {
      partition.next = null;
      result.tail = partition;
    }

    return result;
  }

  public ListNode merge(ListNode leftHead, ListNode rightHead) {
    NodeLinkedList merged = new NodeLinkedList();
    ListNode leftCurrent = leftHead;
    ListNode rightCurrent = rightHead;

    while (leftCurrent != null && rightCurrent != null) {
      if (leftCurrent.val < rightCurrent.val) {
        merged.addNode(leftCurrent);
        leftCurrent = leftCurrent.next;
      } else {
        merged.addNode(rightCurrent);
        rightCurrent = rightCurrent.next;
      }
    }

    while (leftCurrent != null) {
      merged.addNode(leftCurrent);
      leftCurrent = leftCurrent.next;
    }

    while (rightCurrent != null) {
      merged.addNode(rightCurrent);
      rightCurrent = rightCurrent.next;
    }

    return merged.head;
  }

  // Worst case: O(nlogn)
  public ListNode mergeSort(ListNode head) {
    if (head == null) {
      return null;
    }

    // get mid point
    ListNode current = head;
    ListNode previous = null;
    ListNode currentFaster = head;
    while (currentFaster != null) {
      previous = current;
      current = current.next;
      if (currentFaster.next != null) {
        currentFaster = currentFaster.next.next;
      } else {
        break;
      }
    }

    if (current == null) { // only 1 element
      return head;
    }

    ListNode left = head;
    ListNode right = current;
    previous.next = null;

    left = mergeSort(left);
    right = mergeSort(right);

    return merge(left, right);
  }

  public ListNode sortList(ListNode head) {
    // return quickSort(head).head;
    return mergeSort(head);
  }
}

class NodeLinkedList {
  ListNode head = null;
  ListNode tail = null;

  public void addNode(ListNode node) {
    if (head == null) {
      head = node;
      tail = node;
    } else {
      tail.next = node;
      tail = tail.next;
    }
  }
}