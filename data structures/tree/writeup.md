**why** we need tree structure? because using tree we can have a relatively optimized speed in both searching and changing.

# Binary Tree

1. if all leaf nodes are located at the highest level, we call this b-tree a **full binary tree**
2. A **complete binary** tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible

# Huffman Tree  

1. say that the root is at **level 1**, then the path length from root to level n is **n-1**
2. weight path length: the path lengh of a node times the node's weight.
3. A tree's weighted path length(WPL): The summation of all leaf nodes' weieghted path length.
4. Huffman Tree: a tree with the minimum WPL
5. Huffman Coding is used for file compression. How? By rearranging code for different characters.
6. Huffman coding use character frequency as weight, higher frequecy means the character node is closer to the root. 
7. Be aware that Huffman coding is **not unique**. because several nodes could have the same weight, which means this node could be put on either right or left child. Since left child is 0 and right child is 1, coding could vary.


# BST(Binary Search Tree)

1. why BST? if we wanna conduct searching and insertion both at a relatively fast speed, BST is the way to go. (speed for insertion and search is O(logn))
2. what does BST look like? For any node in a tree, left child is smaller than parent and right child is larger.
3. If we do a infix iteration on a BST, we can get a sorted list of number(in ascending order).

# AVL
1. why AVL? bcs if a BST is extremeley unbalanced, its performance(regarding searching) deteriorates FAST. So we optimize BST by making it balanced.
2. what does it look like> for any node, it either has no child at all or the absolute difference between its left and right child tree is no larger than **1**

# B tree(Balanced Tree)
1. All nodes contains data, when an index searching occurs, it runs through all nodes and do a binary search on each node.
## 1. 2-3 tree:
1. all leaf nodes at the same level
2. tree made up with 2-node and 3-node
3. 2-node either has two children or none
4. 3- node either has 3 children or none


# B+ Tree
1. Only leaf nodes contain data, leaf node is a **dense index** for data, non-leaf nodes serve as **sparse index** for leaf nodes. This structure is useful for file storage.