// https://leetcode.com/problems/concatenated-words/

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        HashSet<String> dict = new HashSet<>(Arrays.asList(words));
        List<String> res = new ArrayList<>();

        for(String word : words) {

            if(word.length() == 0) {
                continue;
            }
            dict.remove(word); // remove so that it'll not process self
            if(canForm(word, dict)) {
                res.add(word);
            }
            dict.add(word); // add again
        }
        return res;
    }

    private boolean canForm(String word,  HashSet<String> dict) {
        int n = word.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if(dict.contains(word.substring(j , i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
