import java.util.Optional;
class Solution {
    public int findLUSlength(String[] strs) {
        Map<String, Integer> m = new HashMap();
        for (String str : strs) {
            StringBuilder sb = new StringBuilder();
            bt(sb, 0, str, m);
        }
        Optional<Integer> ans = m.entrySet().stream()
                .filter(el -> el.getValue() == 1)
                .map(el -> el.getKey().length())
                .max(Integer::compareTo);
        return ans.isPresent() ? ans.get() : -1;
    }
    
    public void bt(StringBuilder sb, int index, String ogs, Map<String, Integer> m) {
        if (index >= ogs.length()) {
            String subseq = sb.toString();
            m.put(subseq, m.getOrDefault(subseq, 0)+1);
            return;
        }
        sb.append(ogs.charAt(index));
        bt(sb, index+1, ogs, m);
        sb.deleteCharAt(sb.length()-1);
        bt(sb, index+1, ogs, m);
    }
}