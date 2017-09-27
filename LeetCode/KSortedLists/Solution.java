/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // Runtime: O(n * log(k))
 // where n is the total number of elements in all lists
 // and k is the number of lists
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    Comparator<ListNodeWrapper> nodeComparator = new Comparator<ListNodeWrapper>() {
      public int compare(ListNodeWrapper n1, ListNodeWrapper n2) {
        return n1.node.val - n2.node.val;
      }
    };
    PriorityQueue<ListNodeWrapper> heap = new PriorityQueue<ListNodeWrapper>(nodeComparator);    
  
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        heap.offer(new ListNodeWrapper(lists[i], i));
      }
    }

    ListNode head = null;
    ListNode current = null;

    while (!heap.isEmpty()) {
      ListNodeWrapper currentMin = heap.poll();

      if (currentMin.node.next != null) {
        heap.offer(new ListNodeWrapper(currentMin.node.next, currentMin.listIndex));
      }

      if (head == null) {
        head = currentMin.node;
        current = currentMin.node;
      } else {
        current.next = currentMin.node;
        current = current.next;
      }
    }
    
    return head;
  }
}

class ListNodeWrapper {
  ListNode node;
  int listIndex;
  public ListNodeWrapper(ListNode node, int listIndex) {
    this.node = node;
    this.listIndex = listIndex;
  }
}
