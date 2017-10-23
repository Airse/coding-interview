class RandomizedCollection {
  private ArrayList<Integer> values;
  private HashMap<Integer, ListHashSet> map;
  private int lastIndex = -1;
  private static final Random RANDOM = new Random();

  /** Initialize your data structure here. */
  public RandomizedCollection() {
    values = new ArrayList<Integer>();
    map = new HashMap<Integer, ListHashSet>();
  }
  
  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  public boolean insert(int val) {
    // add to values
    if (lastIndex + 1 < values.size()) {
      lastIndex += 1;
      values.set(lastIndex, val);
    } else {
      lastIndex = values.size();
      values.add(val);
    }

    // add to map
    ListHashSet valSet = map.get(val);
    if (valSet == null) {
      valSet = new ListHashSet();
      map.put(val, valSet);
    }

    valSet.add(lastIndex);

    return valSet.size == 1;
  }
  
  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  public boolean remove(int val) {
    ListHashSet valSet = map.get(val);
    if (valSet == null || valSet.size == 0) {
      return false;
    }

    // swap indexToRemove with last index
    int indexToRemove = valSet.removeHead();
    int lastIndexVal = values.get(lastIndex);

    if (lastIndexVal != val) {
      // process valSet of swapped index
      ListHashSet lastIndexValSet = map.get(lastIndexVal);

      lastIndexValSet.remove(lastIndex);
      lastIndexValSet.add(indexToRemove);

      swapValuesAtIndexes(indexToRemove, lastIndex);
    }

    // remove the lastIndex
    lastIndex--;

    return true;
  }

  private void swapValuesAtIndexes(int i, int j) {
    int temp = values.get(i);
    values.set(i, values.get(j));
    values.set(j, temp);
  }
  
  /** Get a random element from the collection. */
  public int getRandom() {
    int randomIndex = RANDOM.nextInt(lastIndex + 1);
    return values.get(randomIndex);
  }
}

class ListHashSet {
  Node head = null;
  HashMap<Integer, Node> map = new HashMap<Integer, Node>();
  int size = 0;

  public void add(int val) {
    Node newNode = new Node(val);
    newNode.next = head;

    if (head != null)
      head.prev = newNode;

    head = newNode;
    map.put(val, head);

    size++;
  }

  public int removeHead() {
    int val = head.val;

    remove(val);

    return val;
  }

  public void remove(int val) {
    Node nodeToRemove = map.get(val);
    if (nodeToRemove == null) {
      return;
    }

    if (nodeToRemove == head) {
      head.prev = null;
      head = head.next;
    } else {
      if (nodeToRemove.prev != null)
        nodeToRemove.prev.next = nodeToRemove.next;
      if (nodeToRemove.next != null)
        nodeToRemove.next.prev = nodeToRemove.prev;
    }

    map.remove(val);
    size--;
  }
}

class Node {
  int val;
  Node next;
  Node prev;

  public Node(int val) {
    this.val = val;
  }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */