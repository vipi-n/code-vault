// https://www.geeksforgeeks.org/problems/subset-sums2234/1&selectedLang=python3
class Solution {
    
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        
        subSetSum(arr, 0, 0);
        return res;
    }
    
    private void subSetSum(int[] arr, int index, int sum) {
        
        if(index == arr.length) {
           res.add(sum); 
           return;
        }

        // pick that element
        subSetSum(arr, index + 1, sum + arr[index]);
         // not pick that element
        subSetSum(arr, index + 1, sum);
        
    }
}
