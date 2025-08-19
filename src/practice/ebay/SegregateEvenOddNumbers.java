// https://www.geeksforgeeks.org/problems/segregate-even-and-odd-numbers4629/1

// TC : O(n) + nlog(n) = O(n log n)
class Solution {
    void segregateEvenOdd(int arr[]) {
        // code here
        
        int i = 0;
        int j = arr.length - 1;
        
        while(i < j) {
            if(arr[i] % 2 == 0 ) {
                i++;
            } else if(arr[j] % 2 != 0) {
                j--;
            } else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        
        int split = 0;
        
        if(arr[i] % 2 == 0) {
           split = i + 1; 
        } else {
            split = i;
        }
        Arrays.sort(arr, 0, split);
        Arrays.sort(arr, split, arr.length);
        
    }
}
