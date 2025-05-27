class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
    
    ArrayList<Integer> temp = new ArrayList<Integer>();
    int count=0;
    
    for(int i=0;i<queries.length;i++){
        for(int j=0;j<words.length;j++){
            
            char temp1=SmallestCharacter(queries[i]);
            int freq1=freqOfSmallestCharacter(queries[i],temp1);
            char temp2=SmallestCharacter(words[j]);
            int freq2=freqOfSmallestCharacter(words[j],temp2);
            
            if(freq1<freq2){
                count++;
            }
        }
        temp.add(count);
        count=0;
    }
    int size=temp.size();
    int []ans = new int[size];
    for(int i=0;i<size;i++){
        ans[i]=temp.get(i);
    }
    return ans;
}

public int freqOfSmallestCharacter(String str,char a){
    int count=0;
    for(int i=0;i<str.length();i++){
        if(str.charAt(i)==a){
            count++;
        }
    }
    return count;
}

public char SmallestCharacter(String str){
    char temp=str.charAt(0);
    for(int i=0;i<str.length();i++){
        if(temp>str.charAt(i)){
            temp=str.charAt(i);
        }
    }
    return temp;
} 
}
   