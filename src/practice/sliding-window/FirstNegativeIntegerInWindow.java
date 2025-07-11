// https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
class FirstNegativeIntegerInWindow {
    static List<Integer> firstNegInt(int arr[], int k) {
        int i = 0, j = 0;
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        while (j < n) {
            // Add current element to queue if it's negative
            if (arr[j] < 0) {
                queue.add(arr[j]);
            }

            // If window size is less than k, just move j forward
            if (j - i + 1 < k) {
                j++;
            }
            // When window size hits k
            else if (j - i + 1 == k) {
                // Append the first negative number in current window
                if (!queue.isEmpty()) {
                    list.add(queue.peek());
                } else {
                    list.add(0);
                }

                // Remove the element going out of the window
                if (!queue.isEmpty() && queue.peek() == arr[i]) {
                    queue.poll();
                }

                i++;
                j++;
            }
        }

        return list;
    }
}
