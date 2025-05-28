class Solution {
    public int hammingWeight(int n) {
        // first convert it into string
        String binarystring=Integer.toBinaryString(n);
        int count=0;
        for(char c:binarystring.toCharArray())
        {
            if(c=='1'){
                count++;
            }
        }
        return count;
    }
}