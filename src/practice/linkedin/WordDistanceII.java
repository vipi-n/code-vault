// https://www.geeksforgeeks.org/dsa/find-shortest-word-distance-ii/
// https://algo.monster/liteproblems/244

import java.util.*;

class WordDistanceII {
    private Map<String, List<Integer>> wordIndexMap;

    public WordDistanceII(String[] wordsDict) {
        wordIndexMap = new HashMap<>();

        for (int i = 0; i < wordsDict.length; i++) {
            wordIndexMap.putIfAbsent(wordsDict[i], new ArrayList<>());
            wordIndexMap.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indexList1 = wordIndexMap.get(word1);
        List<Integer> indexList2 = wordIndexMap.get(word2);

        int i = 0, j = 0;
        int minDistance = Integer.MAX_VALUE;

        // Two pointer approach
        while (i < indexList1.size() && j < indexList2.size()) {
            int idx1 = indexList1.get(i);
            int idx2 = indexList2.get(j);
            minDistance = Math.min(minDistance, Math.abs(idx1 - idx2));

            // Move the pointer which has smaller index
            if (idx1 < idx2) {
                i++;
            } else {
                j++;
            }
        }

        return minDistance;
    }
}
