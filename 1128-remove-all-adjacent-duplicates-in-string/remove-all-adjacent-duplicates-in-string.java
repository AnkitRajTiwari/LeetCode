class Solution {
    public String removeDuplicates(String s) {
         // since we have to emove the adjacent so use stack
         if(s.length()==1) return s;

         // make a stack
         Stack<Character> stack=new Stack<>();
         // check if current ios not equal
         for(char ch: s.toCharArray()){
            if(stack.isEmpty() || stack.peek()!=ch){
                stack.push(ch);
            }
            else{
                stack.pop();
            }
         }
           
           // to make final 
           String res="";
           while(!stack.isEmpty()){
            res=stack.pop()+res; // since stack pop item in reverse order 
           }
           return res;
    }
}