// https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1

// Recursivve
class MatrixChainMultiplication {

    static int matrixMultiplication(int arr[]) {
        int i = 1;
        int j = arr.length - 1;
        return solve(arr, i, j);
    }

    private static int solve(int arr[], int i, int j) {
        if (i >= j) return 0;

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, cost);
        }

        return min;
    }
}

// memoization
class MatrixChainMultiplication_Memo {

    static int[][] dp;
    static int matrixMultiplication(int arr[]) {
        int n = arr.length; 
        int i = 1;
        int j = n - 1;
        dp = new int[n + 1][n + 1];
        
        for(int[] col : dp) {
            Arrays.fill(col, -1);
        }
        return solve(arr, i, j);
    }

    private static int solve(int arr[], int i, int j) {
        
        if (i >= j) return 0;
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, cost);
            dp[i][j] = min;
        }
        return min;
    }
}

