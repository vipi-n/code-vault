// https://www.naukri.com/code360/problems/subsequences-of-string_985087
class Solution {
    public static List<String> subsequences(String str) {
        List<String> result = new ArrayList<>();
        generateSubsequences(0, str, "", result);
        return result;
    }

    private static void generateSubsequences(int index, String str, String current, List<String> result) {
        if (index == str.length()) {
            result.add(current);
            return;
        }

        // Include current character
        generateSubsequences(index + 1, str, current + str.charAt(index), result);

        // Exclude current character
        generateSubsequences(index + 1, str, current, result);
    }
}

// backtrack


class Solution {
    public static List<String> subsequences(String str) {
        List<String> result = new ArrayList<>();
        backtrack(0, str, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(int index, String str, StringBuilder current, List<String> result) {
        if (index == str.length()) {
            // if (s.length() > 0) if we dont want to add empty
            result.add(current.toString());
            return;
        }
        // Include current character
        current.append(str.charAt(index));
        backtrack(index + 1, str, current, result);
        current.deleteCharAt(current.length() - 1); // Backtrack
        // Exclude current character
        backtrack(index + 1, str, current, result);
    }
}
