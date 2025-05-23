class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack=new Stack<>();
        StringBuilder res=new StringBuilder(s);
        for(int i=0;i<res.length();i++)
        {
            char curr=res.charAt(i);
            if(curr=='(')
            {
                stack.add(i);
            }
            else if(curr==')')
            {
                if(stack.isEmpty())
                {
                    res.deleteCharAt(i);
                    i--;
                }
                else
                {
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty())
        {
            res.deleteCharAt(stack.pop());
        }
        return res.toString();
    }
}