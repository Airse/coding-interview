class LRUCache {
  private int capacity;
  private HashMap<Integer, Node> map;
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<Integer, Node>();
    head = null;
    tail = null;
  }
  
  private void removeNode(Node node) {
    if (node == tail) {
      tail = node.previous;
    }

    if (node == head) {
      head = node.next;
    }

    if (node.previous != null) {
      node.previous.next = node.next;
    }

    if (node.next != null) {
      node.next.previous = node.previous;
    }

    node.next = null;
    node.previous = null;
  }

  private void addNodeToTail(Node node) {
    if (tail == null) {
      head = node;
      tail = node;
    } else {
      tail.next = node;
      node.previous = tail;
      tail = node;
    }
  }

  public void print() {
    System.out.println(".........");
    for (Map.Entry<Integer, Node> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }

  public void printQueue() {
    Node current = head;
    while (current != null) {
      System.out.print(current + " ");
      current = current.next;
    }
    System.out.println();
  }

  public int get(int key) {
    Node node = map.get(key);

    if (node == null) {
      return -1;
    }

    removeNode(node);
    addNodeToTail(node);

    return node.value;
  }
  
  public void put(int key, int value) {
    Node node = map.get(key);

    if (node != null) {
      removeNode(node);
    } else {
      if (map.size() >= capacity) {
        map.remove(head.key);
        removeNode(head);
      }
    }

    node = new Node(key, value);
    map.put(key, node);
    addNodeToTail(node);
  }
}

class Node {
  int key;
  int value;
  Node next = null;
  Node previous = null;

  public Node(int key, int value) {
    this.key = key;
    this.value = value;
  }

  public String toString() {
    return "" + value;
  }
}