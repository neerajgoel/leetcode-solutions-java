# leetcode-solutions-java

My Java solutions to LeetCode problems. Every file runs on its own: its `main` method
runs the problem's LeetCode examples and prints the result next to the expected answer.

```
$ java src/com/questions/_198_House_Robber_01.java
Example 1: got 4   expected 4
Example 2: got 12   expected 12
Video street: got 37   expected 37
```

## Running

Needs Java 11 or newer.

Run one solution directly from its source file:

```
java src/com/questions/_1_Two_Sum_01.java
```

Or compile everything once and run any class:

```
javac -d out src/com/questions/*.java
java -cp out com.questions._1_Two_Sum_01
```

The project also opens as-is in IntelliJ IDEA or VS Code (source root `src`); use the run
button next to `main`.

## How each file is organized

- **File name:** `_<problem number>_<Problem_Title>_<version>.java`. A higher version (`_02`)
  is another approach to the same problem, usually a faster one.
- **Header comment:** time complexity and the LeetCode runtime and memory, or how far the
  submission got (for example "Time Limit Exceeded, 63 / 71 testcases passed").
- **`public class` named like the file**, containing:
  - `main`, which runs LeetCode's examples and prints `got … expected …`;
  - the solution itself, usually as a nested `static class Solution`, the same code that
    was submitted to LeetCode (copy the class body, without `static`, to submit it again);
  - LeetCode's helper types the problem needs (`ListNode`, `TreeNode`, `Node`) and small
    builders such as `list(1, 2, 3)` or `tree(3, 9, 20, null, null, 15, 7)`.

## Problems

| # | Problem | Solution | Notes |
|---|---|---|---|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | [_01](src/com/questions/_1_Two_Sum_01.java) | Hash map |
| 2 | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | [_01](src/com/questions/_2_Add_Two_Numbers_01.java) | |
| 3 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | [_01](src/com/questions/_3_Longest_Substring_Without_Repeating_Characters_01.java) | Sliding window |
| 5 | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) | [_01](src/com/questions/_5_Longest_Palindromic_Substring_01.java) | DP, O(n²) |
| 22 | [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/) | [_01](src/com/questions/_22_Generate_Parentheses_01.java) | Backtracking |
| 25 | [Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | [_01](src/com/questions/_25_Reverse_Nodes_in_k_Group_01.java) | In place |
| 32 | [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/) | [_01](src/com/questions/_32_Longest_Valid_Parentheses_01.java) | Brute force (accepted, 1398 ms) |
| 53 | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) | [_01](src/com/questions/_53_Maximum_Subarray_01.java) | Kadane |
| 91 | [Decode Ways](https://leetcode.com/problems/decode-ways/) | [_01](src/com/questions/_91_decode_ways_01.java) | Memoized recursion |
| 92 | [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/) | [_01](src/com/questions/_92_Reverse_Linked_List_II_01.java) | In place |
| 103 | [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | [_01](src/com/questions/_103_Binary_Tree_Zigzag_Level_Order_Traversal_01.java) | BFS |
| 133 | [Clone Graph](https://leetcode.com/problems/clone-graph/) | [_01](src/com/questions/_133_Clone_Graph_01.java) | DFS + map |
| 146 | [LRU Cache](https://leetcode.com/problems/lru-cache/) | [_01](src/com/questions/_146_LRU_Cache_01.java) | Hash map + doubly linked list, O(1) |
| 151 | [Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/) | [_01](src/com/questions/_151_Reverse_Words_in_a_String_01.java) | |
| 152 | [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/) | [_01](src/com/questions/_153_find_minimum_in_rotated_sorted_array_01.java) | Stored in a file named after 153 |
| 169 | [Majority Element](https://leetcode.com/problems/majority-element/) | [_01](src/com/questions/_169_Majority_Element_01.java) | Boyer-Moore voting |
| 198 | [House Robber](https://leetcode.com/problems/house-robber/) | [_01](src/com/questions/_198_House_Robber_01.java), [_02](src/com/questions/_198_House_Robber_02.java) | DP: _01 array O(n) space, _02 two variables O(1) space |
| 200 | [Number of Islands](https://leetcode.com/problems/number-of-islands/) | [_01](src/com/questions/_200_Number_of_Islands_01.java) | DFS |
| 206 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | [_01](src/com/questions/_206_Reverse_Linked_ListList_01.java) | Recursive |
| 207 | [Course Schedule](https://leetcode.com/problems/course-schedule/) | [_01](src/com/questions/_207_Course_Schedule_01.java) | DFS cycle detection |
| 210 | [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) | [_01](src/com/questions/_210_Course_Schedule_II_01.java) | Topological sort (DFS) |
| 221 | [Maximal Square](https://leetcode.com/problems/maximal-square/) | [_01](src/com/questions/_221_Maximal_Square_01.java) | DP, one row |
| 230 | [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | [_01](src/com/questions/_230_Kth_Smallest_Element_in_a_BST_01.java) | In-order traversal |
| 295 | [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) | [_01](src/com/questions/_295_FindMedianFromDataStream_01.java), [_02](src/com/questions/_295_FindMedianFromDataStream_02.java) | Sorted list: _01 linear insert, _02 binary-search insert |
| 310 | [Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/) | [_01](src/com/questions/_310_Minimum_Height_Trees_01.java), [_02](src/com/questions/_310_Minimum_Height_Trees_02.java) | _01 height from every node (Time Limit Exceeded); _02 trim leaves, O(n) |
| 329 | [Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) | [_01](src/com/questions/_329_Longest_Increasing_Path_in_a_Matrix_01.java) | DFS + memo |
| 430 | [Flatten a Multilevel Doubly Linked List](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/) | [_01](src/com/questions/_430_Flatten_a_Multilevel_Doubly_Linked_List_01.java) | Recursive |
| 445 | [Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/) | [_01](src/com/questions/_445_Add_Two_Numbers_II_01.java) | Pad with zeros + recursion |
| 451 | [Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/) | [_01](src/com/questions/_451_Sort_Characters_By_Frequency_01.java) | Count + sort |
| 515 | [Find Largest Value in Each Tree Row](https://leetcode.com/problems/find-largest-value-in-each-tree-row/) | [_01](src/com/questions/_515_Find_Largest_Value_in_Each_Tree_Row_01.java) | DFS by level |
| 621 | [Task Scheduler](https://leetcode.com/problems/task-scheduler/) | [_01](src/com/questions/_621_Task_Scheduler_01.java) | Max-heap + cooldown queue |
| 695 | [Max Area of Island](https://leetcode.com/problems/max-area-of-island/) | [_01](src/com/questions/_695_Max_Area_of_Island_01.java) | DFS |
| 787 | [Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | [_01](src/com/questions/_787_Cheapest_Flights_Within_K_Stops_01.java), [_02](src/com/questions/_787_Cheapest_Flights_Within_K_Stops_02.java) | _01 brute-force DFS (Time Limit Exceeded); _02 Bellman-Ford, O(E·K) |
| 922 | [Sort Array By Parity II](https://leetcode.com/problems/sort-array-by-parity-ii/) | [_01](src/com/questions/_922_Sort_Array_By_Parity_II_01.java) | Two pointers, in place |
| 987 | [Vertical Order Traversal of a Binary Tree](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/) | [_01](src/com/questions/_987_Vertical_Order_Traversal_of_a_Binary_Tree_01.java) | Work in progress: 14 / 32 testcases pass |
| 993 | [Cousins in Binary Tree](https://leetcode.com/problems/cousins-in-binary-tree/) | [_01](src/com/questions/_993_Cousins_in_Binary_Tree_01.java) | DFS for depth + parent |
| 1462 | [Course Schedule IV](https://leetcode.com/problems/course-schedule-iv/) | [_01](src/com/questions/_1462_Course_Schedule_IV_01.java) | BFS from each queried course |
| 1492 | [The kth Factor of n](https://leetcode.com/problems/the-kth-factor-of-n/) | [_01](src/com/questions/_1492_The_kth_Factor_of_n.java), [_02](src/com/questions/_1492_The_kth_Factor_of_n_02.java) | _01 O(n), _02 O(√n) |
| 1572 | [Matrix Diagonal Sum](https://leetcode.com/problems/matrix-diagonal-sum/) | [_01](src/com/questions/_1572_matrix_diagonal_sum.java) | |
| 2055 | [Plates Between Candles](https://leetcode.com/problems/plates-between-candles/) | [_01](src/com/questions/_2055_Plates_Between_Candles_01.java) | Prefix sums + nearest candle |
| 2402 | [Meeting Rooms III](https://leetcode.com/problems/meeting-rooms-iii/) | [_01](src/com/questions/_2402_Meeting_Rooms_III_01.java) | Simulation with heaps (Time Limit Exceeded, 72 / 82) |
