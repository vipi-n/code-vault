// https://leetcode.com/problems/koko-eating-bananas/description/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        // Find the max pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        // Binary search for the minimum valid eating speed
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, h, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    public boolean canEat(int[] piles, int h, int k) {
        int hours = 0;

        for (int pile : piles) {
            hours += pile / k;
            if (pile % k != 0) {
                hours++; // Extra hour for remainder
            }
            if (hours > h) return false;
        }

        return hours <= h;
    }
}
