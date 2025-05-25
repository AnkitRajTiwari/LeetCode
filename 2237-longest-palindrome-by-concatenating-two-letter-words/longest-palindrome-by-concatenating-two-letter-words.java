class Solution {
    public int longestPalindrome(String[] words) {
        // since each pair of word is a 2d array so make 2D array
        int freq[][]= new int[26][26];
        int count=0;

        for(String word:words)
        {
            int first=word.charAt(0)-'a'; // to check first word
            int second=word.charAt(1)-'a';
            if(freq[second][first]>0)
            {
                count+=4;
                freq[second][first]--; // yaha same pair check kr rhe hai
            }
            else
            {
                freq[first][second]++;// no matching found
            }
        }
        for(int i=0;i<26;i++)
        {
            if(freq[i][i]>0) // yha same letter check kr rhe hai
            {
                count+=2;
                break;
            }
        }
        return count;
    }
}