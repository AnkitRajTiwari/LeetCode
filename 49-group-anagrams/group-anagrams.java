class Solution {
    boolean isAnagram(String first, String second){
        if(first.length()!=second.length()){
            return false;
        }
        char[] x=first.toCharArray();
        char[]y=second.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        return Arrays.equals(x,y);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> biglist= new ArrayList<>();
         for(String word:strs)
         {
            boolean added=false;
            for(List<String>smalllist:biglist)
            {
                if(isAnagram(smalllist.get(0),word)){
                  smalllist.add(word);
                  added=true;
                  break;
                }
            }
            if(!added)
            {
                List<String>newsmall=new ArrayList<>();
                newsmall.add(word);
                biglist.add(newsmall);
            }
         }
         return biglist;
    }
}