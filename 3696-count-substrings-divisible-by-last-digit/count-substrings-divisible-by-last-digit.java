class Solution {
    public long countSubstrings(String s) {
        long[][][] dp=new long[s.length()][3][9];

        if(s.length()==1 && s.charAt(0)!='0') return 1;
        long ans=0;
        int[] a=new int[3];
        a[0]=3;
        a[1]=7;
        a[2]=9;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1' || s.charAt(i)=='2' || s.charAt(i)=='5') ans+=i+1;
            else if(s.charAt(i)=='4'){
                 ans++;
                 if(i!=0 && ((s.charAt(i-1)-'0'))%2==0)
                 ans+=i;
                 
                 }
            else if(s.charAt(i)=='8'){
                int val=8;
                ans++;
                if(i>0) {
                    val+=(s.charAt(i-1)-'0')*10;
                    if(val%8==0) ans++;
                    }
               
                if(i>1) {
                    
                    val+=(s.charAt(i-2)-'0')*100;
                    if(val%8==0)ans+=i-1;
                    }

            }

            int c=s.charAt(i)-'0';
            for(int j=0;j<3;j++){
                for(int k=0;k<a[j] && i!=0;k++){

                    int next=(k*10+c)%a[j];
                    dp[i][j][next]=dp[i-1][j][k];
                }
                dp[i][j][c%a[j]]++;
                if(c==a[j]) ans+=dp[i][j][0];
            }
            if(c==6){
                ans+=dp[i][0][0];
            }

            
        }


        // for(var ele:dp){
        //     for(var v:ele){
        //         for(var b:v) System.out.print(b+ "  ");
        //         System.out.println();

        //     }

        //     // System.out.println();
        // }
        return ans;
    }
}