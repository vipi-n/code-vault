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
