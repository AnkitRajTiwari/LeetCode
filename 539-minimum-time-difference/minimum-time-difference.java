class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<String[]> l= new ArrayList<>();
        for(String i: timePoints){
            String[] a= i.split(":");
            l.add(a);
        }
        List<Integer> time= new ArrayList<>();
        for(String[] a: l){
            time.add(Integer.parseInt(a[0])*60+ Integer.parseInt(a[1]));
        }
        Collections.sort(time);
        int len= time.size();
        for(int i=0; i<len; i++){
            time.add(time.get(i)+1440);
        }
        int min=time.get(time.size()-1);
        for(int i=1; i<time.size(); i++){
            min=Math.min(min, time.get(i)-time.get(i-1));
        }
        return min;
    }
}