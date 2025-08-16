// https://leetcode.com/problems/binary-gap/description/

class Solution {
    public int binaryGap(int n) {

       StringBuilder str = new StringBuilder();

       while(n > 0) {
        int temp = n % 2;
        n = n / 2;
        str.append(String.valueOf(temp));
       } 
       String num = str.reverse().toString();

       int lastSeen = -1;
       int dis = 0;
       for(int i = 0; i < num.length(); i++) {
        
        if(num.charAt(i) == '1') {
           if(lastSeen != -1) {
            dis = Math.max(dis, i - lastSeen); 
           }
           lastSeen = i;
        }
        
       }
     return dis;
    }

      public int binaryGap(int n) {

       String num = Integer.toBinaryString(n);

       int lastSeen = -1;
       int dis = 0;
       for(int i = 0; i < num.length(); i++) {
        
        if(num.charAt(i) == '1') {
           if(lastSeen != -1) {
            dis = Math.max(dis, i - lastSeen); 
           }
           lastSeen = i;
        }
        
       }
     return dis;
    }
}
