class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String word:strs){
            char[] c=word.toCharArray();
            Arrays.sort(c);
            String sortedword=new String(c);

            if(!map.containsKey(sortedword)){
                map.put(sortedword,new ArrayList<>());
            }
            map.get(sortedword).add(word);
        }
        return new ArrayList<>(map.values());
    }
}