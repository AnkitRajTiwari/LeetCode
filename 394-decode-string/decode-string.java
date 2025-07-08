class Solution {
    public String decodeString(String s) {
        Stack<Integer> countstack=new Stack<>(); // to store the 3 
        Stack<StringBuilder> stringstack=new Stack<>(); // to store the previous string before 
                                                         // entering another bracket 
        StringBuilder currentstring=new StringBuilder(); // final string 
        int currentnum=0;

        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                currentnum=currentnum*10 +(c-'0'); // handle multiple digit number 
            }
            else if(c=='['){
                countstack.push(currentnum); // save the prev repeated count
                stringstack.push(currentstring);
                currentstring=new StringBuilder(); // rest it for the new string 
                currentnum=0;
            }
            else if(c==']'){
                // a loop has been closed . pop and calculate the string 
                int repeattimes=countstack.pop();
                StringBuilder stringattached=stringstack.pop(); // get the string to attached 
                                                               // before reparting
                for(int i=0;i<repeattimes;i++){
                    stringattached.append(currentstring);
                }
                currentstring=stringattached;
            }
            else{
                currentstring.append(c);
            }
        }
        return currentstring.toString();
    }
}