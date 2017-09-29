class Solution {
  public int[] smallestRange(List<List<Integer>> nums) {
    int k = nums.size();
    int[] pointers = new int[k];
    
    PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
      public int compare(Node n, Node m) {
        return n.value - m.value;
      }
    });

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int rangeMin = -1;
    int rangeMax = -1;
    for (int i = 0; i < k; i++) {
      int value = nums.get(i).get(pointers[i]);
      pq.offer(new Node(i, value));
      min = Math.min(value, min);
      max = Math.max(value, max);
    }

    int range = max - min;
    rangeMin = min;
    rangeMax = max;

    while (true) {
      Node nodeMin = pq.poll();
      int i = nodeMin.listID;
      pointers[i]++;

      if (pointers[i] < nums.get(i).size()) {
        int value = nums.get(i).get(pointers[i]);
        pq.offer(new Node(i, value));

        max = Math.max(value, max);
        min = pq.peek().value;

        if (max - min < range) {
          range = max - min;
          rangeMin = min;
          rangeMax = max;
        }
      } else {
        break;
      }
    }

    return new int[] { rangeMin, rangeMax };
  }
}

class Node {
  int listID;
  int value;
  public Node(int listID, int value) {
    this.listID = listID;
    this.value = value;
  }
}
