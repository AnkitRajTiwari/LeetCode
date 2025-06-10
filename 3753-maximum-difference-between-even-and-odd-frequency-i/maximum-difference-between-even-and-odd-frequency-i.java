class Solution {
    public int maxDifference(String s) {
        int [] freqmap = new int[26];
        for (char c: s.toCharArray())
        {
            freqmap[c-'a']++;
        }
        int maxoddfreq=0;
        int minevenfreq=Integer.MAX_VALUE;
        for(int freq:freqmap)
        {
            if(freq%2!=0 && freq!=0)
            {
                maxoddfreq=Math.max(maxoddfreq,freq);
            }
            else if(freq>0)
            {
                minevenfreq=Math.min(minevenfreq,freq);
            }
        }
        return maxoddfreq-minevenfreq;
    }
}