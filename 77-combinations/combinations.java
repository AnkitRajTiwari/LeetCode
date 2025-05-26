class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        gen(res,new ArrayList<>(),1,n,k);
        return res;
    }
    public void gen(List<List<Integer>> res,List<Integer> li,int idx,int n,int k){
        if(li.size()==k){
            res.add(new ArrayList<>(li));
            return;
        }

        for(int i=idx;i<=n;i++){
            li.add(i);
            gen(res,li,i+1,n,k);
            li.remove(li.size()-1);
        }
    }
}