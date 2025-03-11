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
}
