# Graph

1. vertex:nodes in graph
2. edge: can have directions and weights
3. graph can be represented by arrays or lists
4. using n*n array to represent a graph with n vertex, 0 in array means not directly linked, 1 means otherwise.
5. list+array: 1*n array filled with n list head, each head means a vertext in graph. Each list represents the vertext directly connected to the list head.
6. DFS:
   - it is a recursion
   - mark whether a node in graph has been visited before
   - pay attention to the situation when node *n* has been deleted in node lists,but has **not** been deleted from edge list.