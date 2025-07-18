// https://www.geeksforgeeks.org/dsa/data-structure-design-for-two-sum-iii/


class TwoSumIII.java {

    private Map<Integer, Integer> numCounts;

    public TwoSum() {
        numCounts = new HashMap<>();
    }

    public void add(int number) {
        numCounts.put(number, numCounts.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (int key : numCounts.keySet()) {
            int complement = value - key;

            if (complement == key) {
                // If complement equals the key, we need at least 2 instances
                if (numCounts.get(key) > 1) {
                    return true;
                }
            } else {
                if (numCounts.containsKey(complement)) {
                    return true;
                }
            }
        }
        return false;
    }
}
