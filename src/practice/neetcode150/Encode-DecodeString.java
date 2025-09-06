// https://chatgpt.com/s/t_68bc885080a4819184c5832fb87d3d16 


public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            // step 1: read length until '#'
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(s.substring(i, j));

            // step 2: extract the actual string
            decoded.add(s.substring(j + 1, j + 1 + len));

            // step 3: move pointer forward
            i = j + 1 + len;
        }
        return decoded;
    }
}
