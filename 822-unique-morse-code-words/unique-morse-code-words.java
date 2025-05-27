class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String [] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> hs = new HashSet<>();
        for(String s : words){
            String ss = "";
            for(int i=0;i<s.length();i++){
                ss+=(arr[s.charAt(i)-'a']);
            }
            hs.add(ss);
        }
        return hs.size();
    }
}