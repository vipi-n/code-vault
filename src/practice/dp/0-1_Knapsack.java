// https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

// 1. Recursion

class Solution {

    static int knapsack(int W, int val[], int wt[]) {
        return knapsack01(W, val, wt, val.length);
    }

    private static int knapsack01(int W, int val[], int wt[], int n) {
        //if no capacity or no items left
        if (W == 0 || n == 0) {
            return 0;
        }

        // If current item can be included, the we can add this or not add this depends on us
        if (W >= wt[n - 1]) {
            return Math.max(
                val[n - 1] + knapsack01(W - wt[n - 1], val, wt, n - 1),
                knapsack01(W, val, wt, n - 1)
            );
        } else {
            // If current item cannot be included, we cannot add this in the bag
            return knapsack01(W, val, wt, n - 1);
        }
    }
}


