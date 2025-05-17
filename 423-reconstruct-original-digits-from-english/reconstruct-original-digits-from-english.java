class Solution {
    public String originalDigits(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        
        int[] result = new int[10];
        result[0] = chars['z' - 'a'];
        result[2] = chars['w' - 'a'];
        result[6] = chars['x' - 'a'];
        result[8] = chars['g' - 'a'];
        result[4] = chars['u' - 'a'];
        result[7] = chars['s' - 'a'];
        result[5] = chars['f' - 'a'];
        result[3] = chars['h' - 'a'];
        result[9] = chars['i' - 'a'];
        result[1] = chars['o' - 'a'];
        
        result[7] -= result[6];
        result[5] -= result[4];
        result[3] -= result[8];
        result[9] -= result[8] + result[5] + result[6];
        result[1] -= result[0] + result[2] + result[4];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < result[i]; j++) {
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}