class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder ans = new StringBuilder();
        if(a > b){
            while(a > 0 && b > 0 && (a/2) < b){
                ans.append("aa").append("bb");
                b -= 2;
                a -= 2;
            }
            while(b > 0){
                ans.append("aa").append("b");
                b--;
                a -= 2;
            }
            while(a > 0){
                ans.append("a");
                a--;
            }
        }
        else if(b > a){
            while(b > 0 && a > 0 && (b/2) < a){
                ans.append("bb").append("aa");
                b -= 2;
                a -= 2;
            }
            while(a > 0){
                ans.append("bb").append("a");
                b -= 2;
                a--;
            }
            while(b > 0){
                ans.append("b");
                b--;
            }
        }
        else{
            while(b > 0 && a > 0){
                ans.append("b").append("a");
                b -= 1;
                a -= 1;
            }
        }
        return ans.toString();
    }
}