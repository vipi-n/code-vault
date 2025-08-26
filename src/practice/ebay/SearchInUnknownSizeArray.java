// https://chatgpt.com/s/t_68ae1d36e7588191a88801645f406b87
// https://chatgpt.com/s/t_68ae1d4b3a408191a450bdd69d10b323
// https://algo.monster/liteproblems/702

/**
 * This is the ArrayReader's API interface.
 * You should not implement it, or speculate about its implementation.
 */
interface ArrayReader {
    public int get(int index);
}

class SearchInUnknownSizeArray {
    public int search(ArrayReader reader, int target) {
        // Step 1: find search boundaries
        int low = 0;
        int high = 1;

        while (reader.get(high) < target) {
            low = high;
            high = high * 2;   // just multiply by 2 or  high <<= 1;
        }

        // Step 2: Binary search in [low, high]
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = reader.get(mid);

            if (val == target) {
                return mid;
            } else if (val > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
