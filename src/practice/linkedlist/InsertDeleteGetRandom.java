//https://leetcode.com/problems/insert-delete-getrandom-o1/
//https://chatgpt.com/s/t_687fed2820588191a45ac17697e7adec

class RandomizedSet {

     List<Integer> list;
    Map<Integer, Integer> map;
    Random rand;

    public RandomizedSet() {
      map = new HashMap<>();
      rand = new Random();
      list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {

        if (!map.containsKey(val)) return false;

        int idx = map.get(val);
        int lastVal = list.get(list.size() - 1);
         // Swap with last element
        list.set(idx, lastVal);
        map.put(lastVal, idx);

        // Remove last element
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
