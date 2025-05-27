class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int eachWordLen = words[0].length();
        int totalLen = eachWordLen * words.length;
        HashMap<String,Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str,map.getOrDefault(str,0) + 1);
        }

        for(int i = 0;i <= s.length() - totalLen;i = i + 1){
            HashMap<String,Integer> chackMap = new HashMap<>();
            for(int j = i;j < i + totalLen; j = j + eachWordLen){
                String sr = s.substring(j,j + eachWordLen);
                chackMap.put(sr,chackMap.getOrDefault(sr,0) + 1);
            }
            if(map.equals(chackMap)){
                list.add(i);
            }
        }
        return list;
    }
}