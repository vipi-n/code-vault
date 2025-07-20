// https://leetcode.com/problems/valid-number/description/
// https://chatgpt.com/s/t_687d43ace6f88191baf20a3b0146288b

class ValidNumber {
    public boolean isNumber(String s) {

        boolean digitSeen = false, eSeen = false, dotSeen = false;
        int countPlusMinus = 0;
        boolean digitAfterE = true; // default true unless e is seen

        int n = s.length();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                digitSeen = true;
                if (eSeen)
                    digitAfterE = true;

            } else if (ch == '+' || ch == '-') {
                if (countPlusMinus == 2) {
                    return false;
                }
                if (i == n - 1) {
                    return false;
                }
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (ch == '.') {
                if (eSeen || dotSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (ch == 'e' || ch == 'E') {
                if (eSeen || !digitSeen || i == n - 1) {
                    return false;
                }
                eSeen = true;
                digitAfterE = false; // must be reset to false
            } else {
                return false;
            }
        }
        return digitSeen && digitAfterE;
    }
}

