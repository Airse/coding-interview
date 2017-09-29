class Solution {
  public int[] findRedundantConnection(int[][] edges) {
    int n = -1;
    for (int i = 0; i < edges.length; i++) {
      n = Math.max(n, edges[i][1]);
    }

    UFDS ufds = new UFDS(n + 1);
    int[] result = { -1, -1 };

    for (int i = 0; i < edges.length; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int rootU = ufds.find(u);
      int rootV = ufds.find(v);
      
      if (rootU == rootV) {
        result[0] = u;
        result[1] = v;
      } else {
        ufds.union(u, v);
      }
    }

    return result;
  }
}

// A Java program to implement Disjoint Set Data Structure.
// Source: http://www.geeksforgeeks.org/disjoint-set-data-structures-java-implementation/
class UFDS {
  int[] size, rank, parent;
  int n;

  // Constructor
  public UFDS(int n) {
    rank = new int[n];
    parent = new int[n];
    size = new int[n];
    this.n = n;
    makeSet();
  }

  int getSize(int x) {
    int root = find(x);

    return size[root];
  }

  // Creates n sets with single item in each
  void makeSet() {
    for (int i = 0; i < n; i++) {
      // Initially, all elements are in
      // their own set.
      parent[i] = i;
      size[i] = 1;
    }
  }

  // Returns representative of x's set
  int find(int x) {
    // Finds the representative of the set
    // that x is an element of
    if (parent[x] != x) {
      // if x is not the parent of itself
      // Then x is not the representative of
      // his set,
      parent[x] = find(parent[x]);

      // so we recursively call Find on its parent
      // and move i's node directly under the
      // representative of this set
    }

    return parent[x];
  }

  // Unites the set that includes x and the set
  // that includes x
  void union(int x, int y) {
    // Find representatives of two sets
    int xRoot = find(x), yRoot = find(y);

    // Elements are in the same set, no need
    // to unite anything.
    if (xRoot == yRoot)
        return;

    // If x's rank is less than y's rank
    if (rank[xRoot] < rank[yRoot]) {
      // Then move x under y so that depth
      // of tree remains less
      parent[xRoot] = yRoot;
      size[yRoot] += size[xRoot];
    } else if (rank[yRoot] < rank[xRoot]) { // Else if y's rank is less than x's rank
      // Then move y under x so that depth of
      // tree remains less
      parent[yRoot] = xRoot;
      size[xRoot] += size[yRoot];
    } else { // if ranks are the same
      // Then move y under x (doesn't matter
      // which one goes where)
      parent[yRoot] = xRoot;
      size[xRoot] += size[yRoot];
      // And increment the the result tree's
      // rank by 1
      rank[xRoot] = rank[xRoot] + 1;
    }
  }
}