class Solution {
    static Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    
    Set<String> setActualWord;
    Map<String, String> mapCaseInSensitiveWord;
    Map<String, String> mapVowelInSensitiveWord;
    
    public String[] spellchecker(String[] wordlist, String[] queries) {
        setActualWord = new HashSet();
        mapCaseInSensitiveWord = new HashMap();
        mapVowelInSensitiveWord = new HashMap();
        
        for(String word : wordlist){
            
            //store the actual word
            setActualWord.add(word);
            
            //store the lowercase word to first found word, 
            String wordLowerCase = word.toLowerCase();
            mapCaseInSensitiveWord.putIfAbsent(wordLowerCase, word);
            
            //replace the vowel in lowercase word with *,
            //store the first word
            String removedVowelWord = removeVowel(wordLowerCase);
            mapVowelInSensitiveWord.putIfAbsent(removedVowelWord, word);
        }
        
        
        String[] results = new String[queries.length];
        
        for(int i = 0; i < results.length; i++){
            results[i] = search(queries[i]);
        }
        
        return results;
    }
    
    private String search(String str){
        
        //return actual word, if found
        if(setActualWord.contains(str)) return str;
        
        String strLowerCase = str.toLowerCase();
        
        //return first word, if it lower case word found
        if(mapCaseInSensitiveWord.containsKey(strLowerCase)) 
            return mapCaseInSensitiveWord.get(strLowerCase);
        
        //return first word, if it vowel in sensitive  word found of lower case 
        String removedVowel = removeVowel(strLowerCase);
        if(mapVowelInSensitiveWord.containsKey(removedVowel))
            return mapVowelInSensitiveWord.get(removedVowel);
        
        //otherwise return empty string
        return "";
    }
    
    private String removeVowel(String str){
        StringBuilder sb = new StringBuilder();
        
        for(char c : str.toCharArray()){
            sb.append(VOWELS.contains(c) ? '*' : c);
        }
        
        return sb.toString();
    }
}