class NumberOfSubstrings {
  // LTE 1
    public int numberOfSubstrings(String s) {
        
        int len = s.length();
        int count = 0;

        for(int i = 0; i < len; i++) {

            int[] temp = new int[3];

            for(int j = i; j < len; j++) {
                
                temp[s.charAt(j) - 'a'] = 1;
                if(temp[0] + temp[1] + temp[2] == 3) {
                   count++;
                }
            }
        }
        return count;
    }
  // LTE 2
  public int numberOfSubstrings(String s) {
        
        int len = s.length();
        int count = 0;

        for(int i = 0; i < len; i++) {

            int[] temp = new int[3];

            for(int j = i; j < len; j++) {
                
                
                temp[s.charAt(j) - 'a'] = 1;
                if(temp[0] + temp[1] + temp[2] == 3) {
                  // if one match is found after that we can just add the remanning size because those subsrting will also have a,b,c chars in it
                   count += len - j;
                   break;
                }
            }
        }
        return count;
    }
  // optimized
      public int numberOfSubstrings(String s) {
        
        int len = s.length();
        int count = 0;
        int[] temp = new int[]{-1, -1, -1};


        for(int i = 0; i < len; i++) {
                
                temp[s.charAt(i) - 'a'] = i;
                if(temp[0] != -1 && temp[1] != -1 && temp[2] != -1) {
                    // Math.min(temp[0], temp[1], temp[2]) We need to check the min in these three, since in java we cannot compare them at once we are doing it 2 at a time
                   int tempMin = Math.min(temp[0], temp[1]);
                   count += 1 + Math.min(tempMin, temp[2]);
            }
        }
        return count;
    }
}
