class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //// sort based on key 
        HashMap<String, List<String>> map=new HashMap<>();

        for(String str: strs)
        {
            /// change string to character to sort it 
            char[] ch= str.toCharArray();
            Arrays.sort(ch);
            /// sorted string became the key 
            String key=new String(ch);

            //// create a list new 
            List<String> list=new ArrayList<>();

            map.putIfAbsent(key, list);

            ///// now get the list associated with the key
            List<String> result=new ArrayList<>();
            result=map.get(key);
            result.add(str);
        }
        List<List<String>> ar=new ArrayList<>(map.values());
        return ar;
    }
}