# Dynamic Programming — Complete Guide

## Table of Contents

- [What is Dynamic Programming?](#what-is-dynamic-programming)
- [When to Use DP](#when-to-use-dp)
- [Recursion vs Memoization vs Tabulation](#recursion-vs-memoization-vs-tabulation)
- [Top-Down vs Bottom-Up](#top-down-vs-bottom-up)
- [Steps to Solve Any DP Problem](#steps-to-solve-any-dp-problem)
- [1D DP Problems](#1d-dp-problems)
- [2D DP Problems](#2d-dp-problems)
- [String DP Problems](#string-dp-problems)
- [Knapsack Pattern](#knapsack-pattern)
- [Subsequence Pattern](#subsequence-pattern)
- [Grid DP Problems](#grid-dp-problems)
- [Interval DP](#interval-dp)
- [State Machine DP](#state-machine-dp)
- [Space Optimization](#space-optimization)
- [Time and Space Complexity](#time-and-space-complexity)
- [Common Patterns Quick Reference](#common-patterns-quick-reference)
- [Must-Solve LeetCode Problems](#must-solve-leetcode-problems)

---

## What is Dynamic Programming?

Dynamic Programming (DP) is an optimization technique that solves problems by:

1. **Breaking** a problem into smaller **overlapping subproblems**
2. **Storing** the results of subproblems to **avoid recomputing** them
3. **Building** the final answer from those stored results

### The Two Key Properties

A problem can be solved with DP if it has:

| Property                      | Meaning                                                    | Example                              |
| ----------------------------- | ---------------------------------------------------------- | ------------------------------------ |
| **Optimal Substructure**      | Optimal solution is built from optimal solutions of subproblems | Shortest path: best path to B = best path to A + A→B |
| **Overlapping Subproblems**   | Same subproblem is solved multiple times                   | Fibonacci: fib(3) is called from fib(4) AND fib(5)   |

### Simple Analogy

```
Without DP (Brute Force):
  "What's 3 + 4?"  → calculates → 7
  "What's 3 + 4?"  → calculates AGAIN → 7
  "What's 3 + 4?"  → calculates AGAIN → 7

With DP (Memoization):
  "What's 3 + 4?"  → calculates → 7 (stores it)
  "What's 3 + 4?"  → already know → 7 ✅ (instant!)
  "What's 3 + 4?"  → already know → 7 ✅ (instant!)
```

---

## When to Use DP

### Keyword Spotting

| Problem Says...                              | Think...      |
| -------------------------------------------- | ------------- |
| "Find the **minimum/maximum**"               | DP            |
| "**Count** the number of ways"               | DP            |
| "Is it **possible** to..."                   | DP            |
| "**Longest/Shortest** subsequence/substring" | DP            |
| "**Partition** into subsets"                  | DP (Knapsack) |
| "**Can you reach** the target?"              | DP            |

### DP vs Greedy vs Backtracking

| Approach        | When to Use                            | Example                      |
| --------------- | -------------------------------------- | ---------------------------- |
| **DP**          | Overlapping subproblems, optimal needed | Longest Common Subsequence   |
| **Greedy**      | Local optimal = Global optimal         | Activity Selection           |
| **Backtracking** | Need ALL solutions, constraints        | N-Queens, Sudoku             |

### NOT DP if:

- No overlapping subproblems (each subproblem is unique)
- Need to find all solutions (usually backtracking)
- Greedy works (no need for DP overhead)

---

## Recursion vs Memoization vs Tabulation

### 1. Plain Recursion (Exponential — BAD)

```java
// Fibonacci — O(2^n) ❌
int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```

```
Call tree for fib(5):
                    fib(5)
                   /      \
              fib(4)      fib(3)     ← fib(3) computed TWICE
             /    \        /   \
         fib(3)  fib(2)  fib(2) fib(1)
         /   \
     fib(2) fib(1)

Same work repeated many times! 💀
```

### 2. Memoization — Top-Down (Recursion + Cache)

```java
// Fibonacci — O(n) ✅
int[] memo = new int[n + 1];
Arrays.fill(memo, -1);

int fib(int n) {
    if (n <= 1) return n;
    if (memo[n] != -1) return memo[n];       // already computed? return it!
    
    memo[n] = fib(n - 1) + fib(n - 2);      // compute and store
    return memo[n];
}
```

```
With memoization:
  fib(5) → fib(4) → fib(3) → fib(2) → fib(1) → fib(0)
                              stored!   stored!
  fib(3)? Already stored! Return immediately ✅
  fib(2)? Already stored! Return immediately ✅

Each subproblem computed ONCE!
```

### 3. Tabulation — Bottom-Up (Iterative)

```java
// Fibonacci — O(n) ✅
int fib(int n) {
    if (n <= 1) return n;
    
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];     // build from bottom up
    }
    
    return dp[n];
}
```

### Comparison

| Aspect         | Recursion    | Memoization (Top-Down) | Tabulation (Bottom-Up) |
| -------------- | ------------ | ---------------------- | ---------------------- |
| Approach       | Brute force  | Recursion + cache      | Iterative + table      |
| Time           | O(2^n)       | O(n)                   | O(n)                   |
| Space          | O(n) stack   | O(n) stack + cache     | O(n) table             |
| Starts from    | —            | Top (big problem)      | Bottom (base case)     |
| Computes       | Everything   | Only what's needed     | All subproblems        |
| Easy to write? | ✅ Easiest   | ✅ Easy (add cache)    | ⚠️ Need to find order  |

---

## Top-Down vs Bottom-Up

### Top-Down (Memoization)

**Start from the answer, break down recursively.**

```java
// "I need fib(5), which needs fib(4) and fib(3), which need..."

int solve(int n, int[] memo) {
    // Base case
    if (n <= 1) return n;
    
    // Already computed?
    if (memo[n] != -1) return memo[n];
    
    // Compute and store
    memo[n] = solve(n - 1, memo) + solve(n - 2, memo);
    return memo[n];
}
```

### Bottom-Up (Tabulation)

**Start from base cases, build up to the answer.**

```java
// "I know fib(0) and fib(1), so I can compute fib(2), then fib(3)..."

int solve(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;  // base case
    dp[1] = 1;  // base case
    
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];  // build up
    }
    return dp[n];
}
```

### When to Use Which?

| Use Top-Down When...                  | Use Bottom-Up When...                |
| ------------------------------------- | ------------------------------------ |
| Recursive thinking is natural         | You know the order of subproblems    |
| Not all subproblems are needed        | Want to avoid recursion stack overflow |
| Hard to determine iteration order     | Want to optimize space               |
| Quick to implement                    | Need best performance                |

### Template: Converting Top-Down to Bottom-Up

```
Step 1: Write recursive solution
Step 2: Add memoization (memo array/map)
Step 3: Identify base cases → dp array initialization
Step 4: Find iteration order (reverse of recursion)
Step 5: Replace recursive calls with dp[] lookups
Step 6: (Optional) Optimize space
```

---

## Steps to Solve Any DP Problem

### The 5-Step Framework

```
1. DEFINE STATE     → What does dp[i] (or dp[i][j]) represent?
2. BASE CASE        → What are the trivial answers?
3. RECURRENCE       → How does dp[i] relate to previous states?
4. ITERATION ORDER  → Which direction to fill the table?
5. FINAL ANSWER     → Where is the answer in the table?
```

### Example: Climbing Stairs

**Problem:** You can climb 1 or 2 steps. How many ways to reach step `n`?

```
1. STATE:       dp[i] = number of ways to reach step i
2. BASE CASE:   dp[0] = 1 (one way to stay at ground)
                dp[1] = 1 (one way to reach step 1)
3. RECURRENCE:  dp[i] = dp[i-1] + dp[i-2]
                (come from one step below OR two steps below)
4. ORDER:       Left to right (i = 2 to n)
5. ANSWER:      dp[n]
```

```java
public int climbStairs(int n) {
    if (n <= 1) return 1;
    
    int[] dp = new int[n + 1];
    dp[0] = 1;                              // base case
    dp[1] = 1;                              // base case
    
    for (int i = 2; i <= n; i++) {          // iteration order
        dp[i] = dp[i - 1] + dp[i - 2];     // recurrence
    }
    
    return dp[n];                           // final answer
}
```

---

## 1D DP Problems

### Pattern: Linear DP

`dp[i]` depends on previous elements like `dp[i-1]`, `dp[i-2]`, etc.

### Fibonacci Numbers

```java
// dp[i] = dp[i-1] + dp[i-2]
public int fib(int n) {
    if (n <= 1) return n;
    int[] dp = new int[n + 1];
    dp[0] = 0; dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
```

### Climbing Stairs

```java
// dp[i] = dp[i-1] + dp[i-2]  (same as Fibonacci!)
public int climbStairs(int n) {
    if (n <= 1) return 1;
    int[] dp = new int[n + 1];
    dp[0] = 1; dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
```

### House Robber

```
Problem: Rob houses, can't rob two adjacent houses. Maximize money.
State:   dp[i] = max money robbing houses 0..i
Recurrence: dp[i] = max(dp[i-1], dp[i-2] + nums[i])
            (skip this house OR rob this house + best from 2 houses back)
```

```java
public int rob(int[] nums) {
    int n = nums.length;
    if (n == 1) return nums[0];
    
    int[] dp = new int[n];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    
    for (int i = 2; i < n; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[n - 1];
}
```

### Coin Change (Min Coins)

```
Problem: Find minimum coins to make amount.
State:   dp[i] = minimum coins to make amount i
Recurrence: dp[i] = min(dp[i - coin] + 1) for each coin
```

```java
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);  // fill with impossible value
    dp[0] = 0;                     // base case: 0 coins for amount 0
    
    for (int i = 1; i <= amount; i++) {
        for (int coin : coins) {
            if (coin <= i) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
}
```

### Longest Increasing Subsequence (LIS)

```
Problem: Find longest strictly increasing subsequence.
State:   dp[i] = length of LIS ending at index i
Recurrence: dp[i] = max(dp[j] + 1) for all j < i where nums[j] < nums[i]
```

```java
public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);  // every element is a subsequence of length 1
    int maxLen = 1;
    
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        maxLen = Math.max(maxLen, dp[i]);
    }
    return maxLen;
}
```

### Maximum Subarray (Kadane's Algorithm)

```
Problem: Find contiguous subarray with maximum sum.
State:   dp[i] = max subarray sum ending at index i
Recurrence: dp[i] = max(nums[i], dp[i-1] + nums[i])
            (start fresh OR extend previous subarray)
```

```java
public int maxSubArray(int[] nums) {
    int currentMax = nums[0];
    int globalMax = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
        currentMax = Math.max(nums[i], currentMax + nums[i]);
        globalMax = Math.max(globalMax, currentMax);
    }
    return globalMax;
}
```

### Word Break

```
Problem: Can the string be segmented into dictionary words?
State:   dp[i] = true if s[0..i-1] can be segmented
Recurrence: dp[i] = true if dp[j] == true AND s[j..i] is in dictionary
```

```java
public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;  // empty string
    
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < i; j++) {
            if (dp[j] && dict.contains(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[n];
}
```

---

## 2D DP Problems

### Pattern: Two Dimensions

`dp[i][j]` depends on combinations of two variables.

### Unique Paths

```
Problem: Robot moves right/down in grid. Count paths from (0,0) to (m-1,n-1).
State:   dp[i][j] = number of ways to reach cell (i,j)
Recurrence: dp[i][j] = dp[i-1][j] + dp[i][j-1]
            (come from above OR come from left)
```

```java
public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    
    // Base case: first row and first column = 1 way
    for (int i = 0; i < m; i++) dp[i][0] = 1;
    for (int j = 0; j < n; j++) dp[0][j] = 1;
    
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }
    return dp[m - 1][n - 1];
}
```

### Minimum Path Sum

```
Problem: Find path from top-left to bottom-right with minimum sum.
State:   dp[i][j] = minimum sum to reach cell (i,j)
Recurrence: dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
```

```java
public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] dp = new int[m][n];
    
    dp[0][0] = grid[0][0];
    for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
    for (int j = 1; j < n; j++) dp[0][j] = dp[0][j - 1] + grid[0][j];
    
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
        }
    }
    return dp[m - 1][n - 1];
}
```

---

## String DP Problems

### Pattern: Two Strings → 2D DP

When comparing two strings, use `dp[i][j]` where `i` = index in string 1, `j` = index in string 2.

### Longest Common Subsequence (LCS)

```
Problem: Find longest subsequence common to both strings.
State:   dp[i][j] = LCS length of s1[0..i-1] and s2[0..j-1]
Recurrence:
  If s1[i-1] == s2[j-1]: dp[i][j] = dp[i-1][j-1] + 1     (characters match)
  Else:                   dp[i][j] = max(dp[i-1][j], dp[i][j-1])  (skip one)
```

```java
public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length(), n = text2.length();
    int[][] dp = new int[m + 1][n + 1];
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    return dp[m][n];
}
```

```
Example: text1 = "abcde", text2 = "ace"

      ""  a  c  e
  ""   0  0  0  0
  a    0  1  1  1
  b    0  1  1  1
  c    0  1  2  2
  d    0  1  2  2
  e    0  1  2  3  ← answer = 3 ("ace")
```

### Longest Common Substring

```
Difference from LCS: Substring must be CONTIGUOUS.
Recurrence:
  If s1[i-1] == s2[j-1]: dp[i][j] = dp[i-1][j-1] + 1
  Else:                   dp[i][j] = 0    ← reset! (must be contiguous)
```

```java
public int longestCommonSubstring(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    int[][] dp = new int[m + 1][n + 1];
    int maxLen = 0;
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
                maxLen = Math.max(maxLen, dp[i][j]);
            }
            // else dp[i][j] = 0 (default)
        }
    }
    return maxLen;
}
```

### Subsequence vs Substring

```
String: "abcde"

Subsequence: "ace" ✅ (can skip characters, order maintained)
Substring:   "bcd" ✅ (must be contiguous)
Substring:   "ace" ❌ (not contiguous)
```

| Aspect     | Subsequence                      | Substring                  |
| ---------- | -------------------------------- | -------------------------- |
| Contiguous | No (can skip)                    | Yes (must be contiguous)   |
| On mismatch | `max(dp[i-1][j], dp[i][j-1])` | Reset to `0`               |
| Example    | LCS, LIS                         | Longest Common Substring   |

### Edit Distance (Levenshtein Distance)

```
Problem: Minimum operations (insert, delete, replace) to convert word1 → word2.
State:   dp[i][j] = min operations to convert word1[0..i-1] to word2[0..j-1]
Recurrence:
  If match:     dp[i][j] = dp[i-1][j-1]           (no operation needed)
  If no match:  dp[i][j] = 1 + min(
                    dp[i-1][j],      // delete from word1
                    dp[i][j-1],      // insert into word1
                    dp[i-1][j-1]     // replace
                )
```

```java
public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    
    // Base cases
    for (int i = 0; i <= m; i++) dp[i][0] = i;  // delete all
    for (int j = 0; j <= n; j++) dp[0][j] = j;  // insert all
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                                Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
    }
    return dp[m][n];
}
```

### Longest Palindromic Subsequence

```
Trick: LPS of string s = LCS of s and reverse(s)
```

```java
public int longestPalindromeSubseq(String s) {
    String rev = new StringBuilder(s).reverse().toString();
    return longestCommonSubsequence(s, rev);
}
```

### Palindrome Substring (Expand Around Center)

```java
// dp[i][j] = true if s[i..j] is a palindrome

public int countSubstrings(String s) {
    int n = s.length(), count = 0;
    boolean[][] dp = new boolean[n][n];
    
    for (int i = n - 1; i >= 0; i--) {         // start from bottom
        for (int j = i; j < n; j++) {
            if (s.charAt(i) == s.charAt(j)) {
                if (j - i <= 2) {
                    dp[i][j] = true;            // length 1, 2, or 3
                } else {
                    dp[i][j] = dp[i + 1][j - 1]; // inner substring
                }
            }
            if (dp[i][j]) count++;
        }
    }
    return count;
}
```

---

## Knapsack Pattern

### The Classic Knapsack Framework

```
Given: Items with weights and values, a capacity limit.
Goal:  Maximize value without exceeding capacity.
```

### 0/1 Knapsack (Take or Skip Each Item)

```
State:   dp[i][w] = max value using items 0..i-1 with capacity w
Recurrence:
  Skip item:  dp[i][w] = dp[i-1][w]
  Take item:  dp[i][w] = dp[i-1][w - weight[i]] + value[i]  (if weight[i] <= w)
  Answer:     dp[i][w] = max(skip, take)
```

```java
public int knapsack(int[] weights, int[] values, int capacity) {
    int n = weights.length;
    int[][] dp = new int[n + 1][capacity + 1];
    
    for (int i = 1; i <= n; i++) {
        for (int w = 0; w <= capacity; w++) {
            dp[i][w] = dp[i - 1][w];  // skip item
            
            if (weights[i - 1] <= w) {
                dp[i][w] = Math.max(dp[i][w],
                    dp[i - 1][w - weights[i - 1]] + values[i - 1]);  // take item
            }
        }
    }
    return dp[n][capacity];
}
```

### Unbounded Knapsack (Can Take Item Multiple Times)

```
Difference: Use dp[i][w - weight] instead of dp[i-1][w - weight]
(same row = can reuse the item)
```

```java
// Coin Change (number of ways) is an unbounded knapsack problem
public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    
    for (int coin : coins) {              // for each item (coin)
        for (int w = coin; w <= amount; w++) {
            dp[w] += dp[w - coin];        // can use coin multiple times
        }
    }
    return dp[amount];
}
```

### Knapsack Variations

| Problem                  | Type        | Key Difference                          |
| ------------------------ | ----------- | --------------------------------------- |
| 0/1 Knapsack             | Take/Skip   | Each item used at most once             |
| Unbounded Knapsack       | Unlimited   | Each item can be used unlimited times   |
| Subset Sum               | 0/1         | "Can we make target sum?"               |
| Equal Partition           | 0/1         | "Can we split into two equal halves?"   |
| Coin Change (min coins)  | Unbounded   | Minimize count                          |
| Coin Change (ways)       | Unbounded   | Count combinations                      |
| Target Sum               | 0/1         | Assign +/- to each element              |

### Subset Sum

```
Problem: Can we select elements that sum to target?
State:   dp[i][s] = can we make sum s using items 0..i-1?
This is knapsack where value = weight = element value.
```

```java
public boolean canPartition(int[] nums) {
    int total = 0;
    for (int n : nums) total += n;
    if (total % 2 != 0) return false;
    
    int target = total / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;
    
    for (int num : nums) {
        for (int s = target; s >= num; s--) {   // reverse for 0/1 knapsack
            dp[s] = dp[s] || dp[s - num];
        }
    }
    return dp[target];
}
```

### 0/1 vs Unbounded — Iteration Order

```java
// 0/1 Knapsack: iterate capacity BACKWARDS (each item used once)
for (int num : nums) {
    for (int s = target; s >= num; s--) {   // ← RIGHT TO LEFT
        dp[s] = dp[s] || dp[s - num];
    }
}

// Unbounded Knapsack: iterate capacity FORWARDS (item can be reused)
for (int coin : coins) {
    for (int s = coin; s <= amount; s++) {   // ← LEFT TO RIGHT
        dp[s] += dp[s - coin];
    }
}
```

**Why?**
- **Backwards (0/1):** Ensures we don't use the same item twice in one round
- **Forwards (Unbounded):** Allows using the same item again

---

## Subsequence Pattern

### Longest Increasing Subsequence (LIS)

```java
// O(n²) approach
public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    int max = 1;
    
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        max = Math.max(max, dp[i]);
    }
    return max;
}

// O(n log n) approach — Binary Search
public int lengthOfLIS(int[] nums) {
    List<Integer> tails = new ArrayList<>();
    
    for (int num : nums) {
        int pos = Collections.binarySearch(tails, num);
        if (pos < 0) pos = -(pos + 1);
        
        if (pos == tails.size()) {
            tails.add(num);
        } else {
            tails.set(pos, num);
        }
    }
    return tails.size();
}
```

### Number of Longest Increasing Subsequence

```java
public int findNumberOfLIS(int[] nums) {
    int n = nums.length;
    int[] length = new int[n];  // length of LIS ending at i
    int[] count = new int[n];   // count of LIS ending at i
    Arrays.fill(length, 1);
    Arrays.fill(count, 1);
    int maxLen = 1;
    
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                if (length[j] + 1 > length[i]) {
                    length[i] = length[j] + 1;
                    count[i] = count[j];
                } else if (length[j] + 1 == length[i]) {
                    count[i] += count[j];
                }
            }
        }
        maxLen = Math.max(maxLen, length[i]);
    }
    
    int result = 0;
    for (int i = 0; i < n; i++) {
        if (length[i] == maxLen) result += count[i];
    }
    return result;
}
```

---

## Grid DP Problems

### Pattern: Moving Through a Grid

Usually `dp[i][j]` depends on cells above (`dp[i-1][j]`) and/or left (`dp[i][j-1]`).

### Unique Paths with Obstacles

```java
public int uniquePathsWithObstacles(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    if (grid[0][0] == 1) return 0;
    
    int[][] dp = new int[m][n];
    dp[0][0] = 1;
    
    for (int i = 1; i < m; i++) dp[i][0] = grid[i][0] == 1 ? 0 : dp[i - 1][0];
    for (int j = 1; j < n; j++) dp[0][j] = grid[0][j] == 1 ? 0 : dp[0][j - 1];
    
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = grid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
        }
    }
    return dp[m - 1][n - 1];
}
```

### Maximal Square

```
Problem: Find largest square containing only 1's.
State:   dp[i][j] = side length of largest square with bottom-right at (i,j)
Recurrence: dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
```

```java
public int maximalSquare(char[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[m + 1][n + 1];
    int maxSide = 0;
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (matrix[i - 1][j - 1] == '1') {
                dp[i][j] = Math.min(dp[i - 1][j],
                            Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
    }
    return maxSide * maxSide;
}
```

---

## Interval DP

### Pattern: Solve for All Intervals [i, j]

Problems where you need to consider all possible subranges.

### Matrix Chain Multiplication / Burst Balloons

```
State:   dp[i][j] = optimal answer for range [i..j]
Recurrence: Try all possible split points k in [i..j]
            dp[i][j] = best of dp[i][k] + dp[k][j] + cost(i, k, j)
```

### Burst Balloons

```java
public int maxCoins(int[] nums) {
    int n = nums.length;
    int[] balls = new int[n + 2];
    balls[0] = balls[n + 1] = 1;
    for (int i = 0; i < n; i++) balls[i + 1] = nums[i];
    
    int[][] dp = new int[n + 2][n + 2];
    
    for (int len = 1; len <= n; len++) {           // length of interval
        for (int i = 1; i + len - 1 <= n; i++) {   // start
            int j = i + len - 1;                    // end
            for (int k = i; k <= j; k++) {          // split point (last to burst)
                dp[i][j] = Math.max(dp[i][j],
                    dp[i][k - 1] + dp[k + 1][j] + balls[i - 1] * balls[k] * balls[j + 1]);
            }
        }
    }
    return dp[1][n];
}
```

### Palindrome Partitioning II (Min Cuts)

```java
public int minCut(String s) {
    int n = s.length();
    boolean[][] isPal = new boolean[n][n];
    int[] dp = new int[n];
    
    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPal[i + 1][j - 1])) {
                isPal[i][j] = true;
            }
        }
    }
    
    Arrays.fill(dp, Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) {
        if (isPal[0][i]) {
            dp[i] = 0;
        } else {
            for (int j = 1; j <= i; j++) {
                if (isPal[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
    }
    return dp[n - 1];
}
```

---

## State Machine DP

### Pattern: Multiple States at Each Step

Track which "state" you're in (e.g., holding stock, not holding stock, in cooldown).

### Best Time to Buy and Sell Stock with Cooldown

```
States:
  hold[i]    = max profit on day i if HOLDING stock
  notHold[i] = max profit on day i if NOT holding stock
  cooldown[i] = max profit on day i if in COOLDOWN

Transitions:
  hold[i]     = max(hold[i-1], notHold[i-1] - price[i])    // keep or buy
  notHold[i]  = max(notHold[i-1], cooldown[i-1])            // keep or exit cooldown
  cooldown[i] = hold[i-1] + price[i]                        // sell
```

```java
public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n <= 1) return 0;
    
    int hold = -prices[0];
    int notHold = 0;
    int cooldown = 0;
    
    for (int i = 1; i < n; i++) {
        int prevHold = hold;
        hold = Math.max(hold, notHold - prices[i]);
        notHold = Math.max(notHold, cooldown);
        cooldown = prevHold + prices[i];
    }
    return Math.max(notHold, cooldown);
}
```

### Best Time to Buy and Sell Stock with Transaction Fee

```java
public int maxProfit(int[] prices, int fee) {
    int hold = -prices[0];    // holding stock
    int cash = 0;             // not holding stock
    
    for (int i = 1; i < prices.length; i++) {
        hold = Math.max(hold, cash - prices[i]);
        cash = Math.max(cash, hold + prices[i] - fee);
    }
    return cash;
}
```

### Best Time to Buy and Sell Stock — At Most K Transactions

```java
public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (n <= 1) return 0;
    
    // dp[t][i] = max profit using at most t transactions up to day i
    int[][] dp = new int[k + 1][n];
    
    for (int t = 1; t <= k; t++) {
        int maxPrev = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[t][i] = Math.max(dp[t][i - 1], maxPrev + prices[i]);
            maxPrev = Math.max(maxPrev, dp[t - 1][i] - prices[i]);
        }
    }
    return dp[k][n - 1];
}
```

---

## Space Optimization

### Technique 1: 2D → 1D Array

When `dp[i]` only depends on `dp[i-1]`, keep only one row.

```java
// Before: O(m × n) space
int[][] dp = new int[m][n];
for (int i = 1; i < m; i++) {
    for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    }
}

// After: O(n) space
int[] dp = new int[n];
Arrays.fill(dp, 1);
for (int i = 1; i < m; i++) {
    for (int j = 1; j < n; j++) {
        dp[j] = dp[j] + dp[j - 1];  // dp[j] has previous row value
    }
}
```

### Technique 2: 1D → Two Variables

When `dp[i]` only depends on `dp[i-1]` and `dp[i-2]`.

```java
// Before: O(n) space
int[] dp = new int[n];
dp[0] = 0; dp[1] = 1;
for (int i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2];
}

// After: O(1) space
int prev2 = 0, prev1 = 1;
for (int i = 2; i <= n; i++) {
    int curr = prev1 + prev2;
    prev2 = prev1;
    prev1 = curr;
}
```

### Space Optimization Summary

| Original Space | Optimization           | Condition                        |
| -------------- | ---------------------- | -------------------------------- |
| O(n)           | O(1) — two variables   | dp[i] depends on dp[i-1], dp[i-2] |
| O(m × n)       | O(n) — single row      | dp[i][j] depends only on row i-1  |
| O(m × n)       | O(2n) — two rows       | dp[i][j] depends on row i-1 and i |

---

## Time and Space Complexity

### Common DP Problems Complexity

| Problem                       | Time       | Space       | Optimized Space |
| ----------------------------- | ---------- | ----------- | --------------- |
| Fibonacci                     | O(n)       | O(n)        | O(1)            |
| Climbing Stairs               | O(n)       | O(n)        | O(1)            |
| House Robber                  | O(n)       | O(n)        | O(1)            |
| Coin Change                   | O(n × m)   | O(n)        | O(n)            |
| LIS                           | O(n²)      | O(n)        | O(n log n)      |
| LCS                           | O(m × n)   | O(m × n)    | O(n)            |
| Edit Distance                 | O(m × n)   | O(m × n)    | O(n)            |
| 0/1 Knapsack                  | O(n × W)   | O(n × W)    | O(W)            |
| Unique Paths                  | O(m × n)   | O(m × n)    | O(n)            |
| Maximal Square                | O(m × n)   | O(m × n)    | O(n)            |
| Longest Palindromic Subseq    | O(n²)      | O(n²)       | O(n)            |
| Burst Balloons                | O(n³)      | O(n²)       | —               |

### General Rule

```
Time  = Number of states × Time per state
Space = Number of states (can often be optimized)
```

---

## Common Patterns Quick Reference

### Pattern Cheat Sheet

| Pattern             | State                          | Recurrence Idea                      | Example Problems                     |
| ------------------- | ------------------------------ | ------------------------------------ | ------------------------------------ |
| **Linear**          | `dp[i]`                       | Based on dp[i-1], dp[i-2]           | Fibonacci, Climbing Stairs, House Robber |
| **Knapsack**        | `dp[i][w]` or `dp[w]`         | Take or skip item                    | Knapsack, Subset Sum, Coin Change    |
| **String (2 str)**  | `dp[i][j]`                    | Match/mismatch at i,j               | LCS, Edit Distance                   |
| **String (1 str)**  | `dp[i][j]`                    | Is s[i..j] palindrome?              | Palindrome problems                  |
| **Grid**            | `dp[i][j]`                    | From top/left                        | Unique Paths, Min Path Sum           |
| **Interval**        | `dp[i][j]`                    | Split at k in [i..j]                | Burst Balloons, Matrix Chain         |
| **State Machine**   | Multiple dp arrays             | Transitions between states           | Stock problems                       |
| **Subsequence**     | `dp[i]`                       | Best ending at/up to i               | LIS, Max Subarray                    |
| **Counting**        | `dp[i]`                       | Sum of ways from previous states     | Decode Ways, Staircase               |

### How to Identify the Pattern

```
"Maximum/Minimum value"           → Optimization DP
"Count number of ways"            → Counting DP
"Is it possible?"                 → Boolean DP
"Two strings, compare"            → String DP (2D)
"Items with weight/value"         → Knapsack
"Grid traversal, path"            → Grid DP
"Range/interval based"            → Interval DP
"Buy/sell, hold/not hold"         → State Machine DP
"Longest increasing..."           → Subsequence DP
```

### The Decision Tree

```
                        DP Problem?
                       /          \
                 1D Input          2D Input
                /      \           /       \
          Linear    Knapsack    Grid      String
           |           |         |          |
     dp[i-1],dp[i-2]  Take/Skip  From     Two strings?
                                top/left   → dp[i][j]
```

---

## Must-Solve LeetCode Problems

### Beginner (Start Here)

| #    | Problem               | Pattern        | Difficulty |
| ---- | --------------------- | -------------- | ---------- |
| 509  | Fibonacci Number      | Linear         | Easy       |
| 70   | Climbing Stairs       | Linear         | Easy       |
| 746  | Min Cost Climbing Stairs | Linear      | Easy       |
| 198  | House Robber          | Linear         | Medium     |
| 213  | House Robber II       | Linear         | Medium     |
| 53   | Maximum Subarray      | Kadane's       | Medium     |

### Knapsack / Subset

| #    | Problem               | Pattern        | Difficulty |
| ---- | --------------------- | -------------- | ---------- |
| 322  | Coin Change           | Unbounded      | Medium     |
| 518  | Coin Change II        | Unbounded      | Medium     |
| 416  | Partition Equal Subset | 0/1 Knapsack  | Medium     |
| 494  | Target Sum            | 0/1 Knapsack  | Medium     |
| 474  | Ones and Zeroes       | 0/1 Knapsack  | Medium     |

### String DP

| #    | Problem               | Pattern        | Difficulty |
| ---- | --------------------- | -------------- | ---------- |
| 1143 | Longest Common Subsequence | Two String | Medium     |
| 72   | Edit Distance         | Two String     | Medium     |
| 516  | Longest Palindromic Subsequence | Palindrome | Medium |
| 5    | Longest Palindromic Substring | Palindrome | Medium   |
| 647  | Palindromic Substrings | Palindrome    | Medium     |
| 139  | Word Break            | String         | Medium     |

### Grid DP

| #    | Problem               | Pattern        | Difficulty |
| ---- | --------------------- | -------------- | ---------- |
| 62   | Unique Paths          | Grid           | Medium     |
| 63   | Unique Paths II       | Grid           | Medium     |
| 64   | Minimum Path Sum      | Grid           | Medium     |
| 221  | Maximal Square        | Grid           | Medium     |
| 120  | Triangle              | Grid           | Medium     |

### Subsequence

| #    | Problem               | Pattern        | Difficulty |
| ---- | --------------------- | -------------- | ---------- |
| 300  | Longest Increasing Subsequence | LIS   | Medium     |
| 673  | Number of LIS         | LIS            | Medium     |
| 1048 | Longest String Chain   | LIS variant   | Medium     |
| 354  | Russian Doll Envelopes | 2D LIS        | Hard       |

### Stock Problems (State Machine)

| #    | Problem               | Pattern        | Difficulty |
| ---- | --------------------- | -------------- | ---------- |
| 121  | Best Time to Buy and Sell Stock | Basic  | Easy       |
| 122  | Best Time II (unlimited) | Greedy/DP   | Medium     |
| 309  | With Cooldown         | State Machine  | Medium     |
| 714  | With Transaction Fee  | State Machine  | Medium     |
| 123  | At Most 2 Transactions | State Machine | Hard       |
| 188  | At Most K Transactions | State Machine | Hard       |

### Advanced

| #    | Problem               | Pattern        | Difficulty |
| ---- | --------------------- | -------------- | ---------- |
| 312  | Burst Balloons        | Interval       | Hard       |
| 1312 | Min Insertions for Palindrome | String | Hard       |
| 97   | Interleaving String   | Two String     | Medium     |
| 115  | Distinct Subsequences | Two String     | Hard       |
| 10   | Regular Expression Matching | String   | Hard       |
| 44   | Wildcard Matching     | String         | Hard       |
