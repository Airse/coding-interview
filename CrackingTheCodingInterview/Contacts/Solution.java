import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  private TrieNode root = new TrieNode();

  public int find(String partial) {
    return findInTrie(root, partial, 0);
  }

  private int findInTrie(TrieNode root, String partial, int index) {
    if (index >= name.length()) {
      return root.count;
    }

    char c = name.charAt(index);
    TrieNode child = root.children.get(c);
    if (child == null) {
      return 0;
    }
    return findInTrie(child, partial, index + 1);
  }

  public void add(String name) {
    addToTrie(root, name, 0);
  }

  private void addToTrie(TrieNode root, String name, int index) {
    root.count++;

    if (index >= name.length()) {
      return;
    }

    char c = name.charAt(index);
    TrieNode child = root.children.get(c);

    if (child == null) {
      child = new TrieNode();
      root.children.put(c, child);
    }

    addToTrie(child, name, index + 1);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    Solution solution = new Solution();
    for (int a0 = 0; a0 < n; a0++) {
        String op = in.next();
        String contact = in.next();

        switch (op) {
          case "add":
            solution.add(contact);
            break;
          case "find":
            System.out.println(solution.find(contact));
            break;
        }
    }

    in.close();
  }
}

class TrieNode {
  Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  int count = 0;
}