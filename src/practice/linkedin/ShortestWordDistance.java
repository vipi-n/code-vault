//https://www.geeksforgeeks.org/problems/closest-strings0611/1

// User function Template for Java

class Solution {
    int shortestDistance(ArrayList<String> s, String word1, String word2) {
        // code here
        

        int n = s.size();
        int i1 = -1;
        int i2= -1;
        int minDis = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            if(s.get(i).equals(word1)) {
                i1 = i;
            }
            if(s.get(i).equals(word2)) {
                i2 = i;
            }
            if (i1 != -1 && i2 != -1) {
            minDis = Math.min(minDis, Math.abs(i1- i2));
                
            }
            
         }
         return minDis;
    }
}
