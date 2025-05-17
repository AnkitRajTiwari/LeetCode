class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String,Integer> word = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            // for(int j = minSize;j<=maxSize;j++){
                if(i+minSize<=s.length()){
                    String sub = s.substring(i,i+minSize);
                    Map<Character,Integer> map = new HashMap<>();
                    for(char c : sub.toCharArray()){
                        map.put(c, map.getOrDefault(c, 0)+1);
                    }
                    if(map.size()<=maxLetters){
                        word.put(sub, word.getOrDefault(sub,0)+1);
                    }
                }
            // }
        }
        int maxLen = 0;
        for(String key : word.keySet()){
            if(word.get(key)>maxLen){
                maxLen = word.get(key);
            }
        }
        return maxLen;
    }
}