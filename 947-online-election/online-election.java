class TopVotedCandidate {
    TreeMap<Integer,Integer> mp=new TreeMap<>(); 
    HashMap<Integer,Integer> mp_2=new HashMap<>();
    int lead=-1;
    public TopVotedCandidate(int[] persons, int[] times) {
        for(int i=0;i<persons.length;i++){
            mp_2.put(persons[i],mp_2.getOrDefault(persons[i],0)+1);
            if(lead==-1 || mp_2.get(persons[i]) >= mp_2.get(lead)){
                lead=persons[i];
            }
            mp.put(times[i],lead);
        }
    }
    
    public int q(int t) {
        int idx = mp.floorKey(t);
        return mp.get(idx);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */