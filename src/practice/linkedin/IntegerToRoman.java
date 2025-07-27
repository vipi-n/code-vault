// https://leetcode.com/problems/integer-to-roman/

class IntegerToRoman {
    public String intToRoman(int num) {
        
        String[] symbols ={"M",  "CM","D", "CD","C", "XC","L", "XL","X", "IX","V", "IV","I"};
        int[] values =    {1000, 900, 500, 400, 100,  90,  50,  40,  10,   9,   5,   4,   1};
        
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < values.length && num > 0; i++) {
           while(num >= values[i]) {
            num -= values[i];
            sb.append(symbols[i]);
           }
        }
        return sb.toString();
    }
}
