class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> hm1 = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();

        List<Integer> ls= new ArrayList<>();
        
        for(int a : nums1) hm1.put(a , hm1.getOrDefault(a,0)+1);
        for(int a : nums2) hm2.put(a , hm2.getOrDefault(a,0)+1);

        for(Map.Entry<Integer,Integer> e : hm1.entrySet()){
            int count = Math.min(e.getValue() , hm2.getOrDefault(e.getKey() , 0));
            for(int i=0;i<count;i++) ls.add(e.getKey());
        }
        int[] ans = ls.stream().mapToInt(Integer::intValue).toArray();
        return ans;

    }
}