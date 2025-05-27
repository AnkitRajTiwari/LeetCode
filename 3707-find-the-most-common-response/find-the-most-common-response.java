class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        // keep a count of times seen in map
        HashMap<String, Integer> frequencyMap = new HashMap<>();

        String mostFrequentTerm = "";
        Integer maxFreq = 0;

        // Iterate over the daily responses, update the map and keep track of highest freq
        for (List<String> response : responses) {
            HashSet<String> seen = new HashSet<>(response); // one liner addition to HashSet

            for(String term : seen){ // each entry in HashSet
                int freq = frequencyMap.getOrDefault(term, 0) + 1;

                // update the frequency map
                frequencyMap.put(term, freq);

                // update if it is highest Freq Term
                if(freq > maxFreq){
                    maxFreq = freq;
                    mostFrequentTerm=term;
                } else if(freq == maxFreq && term.compareTo(mostFrequentTerm)<0){
                    mostFrequentTerm = term;
                }
            }
        }
        
        return mostFrequentTerm;
    }
}