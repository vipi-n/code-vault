// https://leetcode.com/problems/find-the-celebrity/
/* The knows API is defined in the parent class Relation.
   boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;

        // Step 1: Find a potential celebrity
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;

            // A celebrity should not know anyone,
            // and everyone should know the celebrity
            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }
}
