
class LFUCache {
  private int capacity;
  private HashMap<Integer, Node> nodeMap;
  private HashMap<Integer, Integer> valueMap;
  private NodeList nodeList;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    valueMap = new HashMap<Integer, Integer>();
    nodeMap = new HashMap<Integer, Node>();
    nodeList = new NodeList();
    nodeList.addNode(new Node(1));
  }
  
  public int get(int key) {
    boolean exists = valueMap.get(key) != null;
    if (!exists) {
      return -1;
    }

    Node next = removeFromNodeAndGetNext(key, nodeMap.get(key));
    next.addKey(key);
    nodeMap.remove(key);
    nodeMap.put(key, next);

    return valueMap.get(key);
  }

  private void invalidateItem() {
    Node current = nodeList.head;
    while (current != null) {
      if (current.keysSet.size() > 0) {
        int lru = current.removeLRU();
        valueMap.remove(lru);
        break;
      }
      current = current.next;
    }

    if (current != null && current.freq != 1 && current.keysSet.size() == 0) {
      nodeList.removeNode(current);
    }
  }

  private Node removeFromNodeAndGetNext(int key, Node node) {
    node.removeKey(key);

    if (node.next == null || node.next.freq != node.freq + 1) {
      Node nextNode = new Node(node.freq + 1);
      nodeList.addAfter(node, nextNode);
    }
    node = node.next;

    if (node.prev.freq != 1 && node.prev.keysSet.size() == 0) {
      nodeList.removeNode(node.prev);
    }

    return node;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }

    boolean exists = valueMap.get(key) != null;
    Node node = nodeMap.get(key);

    if (!exists) {
      if (valueMap.size() >= capacity) {
        invalidateItem();
      }
      node = nodeList.head;
    } else {
      node = removeFromNodeAndGetNext(key, node);
    }

    node.addKey(key);

    nodeMap.remove(key);
    nodeMap.put(key, node);
    valueMap.put(key, value);
  }
}

class NodeList {
  Node head;
  Node tail;

  public void print() {
    Node current = head;
    while (current != null) {
      System.out.print(current.freq + "-" + current + " => ");
      current = current.next;
    }
    System.out.println();
  }

  public void addNode(Node node) {
    if (head == null) {
      head = node;
      tail = node;
    } else {
      tail.next = node;
      node.prev = tail;
      tail = node;
    }
    tail.next = null;
  }

  public void addAfter(Node before, Node node) {
    if (before == tail) {
      addNode(node);
    } else {
      Node next = before.next;
      before.next = node;
      node.next = next;

      next.prev = node;
      node.prev = before;
    }
  }

  public void removeNode(Node node) {
    if (node == head) {
      head = head.next;
      head.prev = null;
    }
    if (node == tail) {
      tail = tail.prev;
      tail.next = null;
    }
    if (node.next != null) {
      node.next.prev = node.prev;
    }
    if (node.prev != null) {
      node.prev.next = node.next;
    }
  }
}

class Node {
  LinkedHashSet<Integer> keysSet = new LinkedHashSet<Integer>();
  int freq;
  Node next;
  Node prev;

  public Node(int freq) {
    this.freq = freq;
  }

  public void addKey(int key) {
    keysSet.add(key);
  }

  public void removeKey(int key) {
    keysSet.remove(key);
  }

  public int removeLRU() {
    int toRemove = -1;
    for (int key : keysSet) {
      toRemove = key;
      break;
    }

    keysSet.remove(toRemove);

    return toRemove;
  }

  public String toString(){
    String result = "";
    for (int key : keysSet) {
      result += key + " ";
    }
    return result;
  }
}
