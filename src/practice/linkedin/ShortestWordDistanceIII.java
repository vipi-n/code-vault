// https://algo.monster/liteproblems/245
// https://chatgpt.com/s/t_6881367d485481918a075a28b68d8512

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;

        if (!word1.equals(word2)) {
            int inx1 = -1, inx2 = -1;
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    inx1 = i;
                }
                if (wordsDict[i].equals(word2)) {
                    inx2 = i;
                }
                if (inx1 != -1 && inx2 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(inx1 - inx2));
                }
            }
        } else {
            int prevIndex = -1;
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    if (prevIndex != -1) {
                        minDistance = Math.min(minDistance, i - prevIndex);
                    }
                    prevIndex = i;
                }
            }
        }

        return minDistance;
    }
}
