class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        for(char c:s.toCharArray()){
            if(!st1.isEmpty() && c==st1.peek()){
                st2.push(st2.peek()+1);
            }
            else{
                st2.push(1);
            }
            st1.push(c);
            if(st2.peek()==k){
                for(int i=0;i<k;i++){
                    st1.pop();
                    st2.pop();
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:st1){
            sb.append(c);
        }
        return sb.toString();
    }
}