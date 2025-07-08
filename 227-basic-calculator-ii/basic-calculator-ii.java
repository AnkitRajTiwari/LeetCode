class Solution {
    public int calculate(String s) {
        // First, remove spaces from the input string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            sb.append(s.charAt(i));
        }
        s = sb.toString();
        
        // Then perform the calculation using num, res, and sign
        int num = 0;
        int res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // Build the current number by adding the new digit
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                // Add the accumulated number to the result and reset num, set sign to positive
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                // Add the accumulated number to the result and reset num, set sign to negative
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '*') {
                // Perform multiplication
                int nextNum = 0;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    nextNum = nextNum * 10 + (s.charAt(i) - '0');
                }
                num = num * nextNum;
            } else if (c == '/') {
                // Perform division
                int nextNum = 0;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    nextNum = nextNum * 10 + (s.charAt(i) - '0');
                }
                num = num / nextNum;
            }
        }
        // Finally, add the last accumulated number to the result
        res += sign * num;
        return res;
    }
}