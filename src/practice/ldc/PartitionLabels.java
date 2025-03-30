// https://leetcode.com/problems/partition-labels/description/

class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        
        int[] index = new int[26];
        List<Integer> list = new ArrayList<>();
        int len = s.length();

        for(int i = 0; i < len; i++) {
                index[s.charAt(i) - 'a'] = i;
            }
        
        int i = 0;
        while(i < len) {

        int end = index[s.charAt(i) - 'a'];

        for(int j = i; j < end; j++) {
            end = Math.max(end, index[s.charAt(j) - 'a']);
        }
        list.add(end - i + 1);
        i = end + 1;
        } 
        return list;  
    }
  //
   public List<Integer> partitionLabels(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int len = s.length();

        for(int i = 0; i < len; i++) {
                map.put(s.charAt(i), i);
            }
        
        int i = 0;
        while(i < len) {

        int end = map.get(s.charAt(i));

        for(int j = i; j < end; j++) {
            end = Math.max(end,map.get(s.charAt(j)));
        }
        list.add(end - i + 1);
        i = end + 1;
        } 
        return list;  
    }
}
