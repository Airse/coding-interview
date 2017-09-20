# Trees: Is This a Binary Search Tree?

[Source](https://www.hackerrank.com/challenges/ctci-is-binary-search-tree)

For the purposes of this challenge, we define a binary search tree to be a binary tree with the following ordering properties:

- The `data` value of every node in a node's left subtree is less than the data value of that node.
- The `data` value of every node in a node's right subtree is greater than the data value of that node.
Given the root node of a binary tree, can you determine if it's also a binary search tree?

Complete the function in your editor below, which has `1` parameter: a pointer to the root of a binary tree. It must return a boolean denoting whether or not the binary tree is a binary search tree. You may have to write one or more helper functions to complete this challenge.

Note: We do not consider a binary tree to be a binary search tree if it contains duplicate values.