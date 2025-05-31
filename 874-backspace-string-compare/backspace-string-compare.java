class Solution {
    public boolean backspaceCompare(String s, String t) {
        // two pointer
        // this does not passes all the test cases 
        // for(int i=0;i<s.length();i++)
       // {
        //    for(int j=0;j<t.length();j++){
          //     if(s.charAt(i) == '#' && t.charAt(j) == '#')
           //     {
             //       return true;
               // }
            //}
      //  }
       // return false;
       StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(ch == '#') {
                if(!sb1.isEmpty()) {
                    sb1.deleteCharAt(sb1.length() - 1);
                }
            } else {
                sb1.append(ch);
            }
        }

        for(char ch : t.toCharArray()) {
            if(ch == '#') {
                if(!sb2.isEmpty()) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
            } else {
                sb2.append(ch);
            }
        }

        return sb1.toString().equals(sb2.toString());

    }
}