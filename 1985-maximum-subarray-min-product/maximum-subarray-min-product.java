class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long max = Long.MIN_VALUE;
        long[] psum = new long[n+1]; // prefix sum
        for(int i = 0; i < n; i++){
            psum[i+1] = psum[i] + nums[i];
        }
        int[] NSEL = smallerOnLeft(nums); // next smaller element on left
        int[] NSER = smallerOnRight(nums); // next smaller element on right
        for(int i = 0; i < n; i++){
            long min = nums[i];
            int lr = NSEL[i];// left range
            int rr = NSER[i];// right range
            long sum = psum[rr] - psum[lr+1];
            long minProduct = sum * min;
            max = Math.max(minProduct,max);
        }
        return (int)(max % 1000000007);

    }
    public int[] smallerOnLeft(int[] arr){
        
    int[] lb = new int[arr.length]; // nse on the left
    Stack<Integer> st = new Stack<>();

    st.push(0);
    lb[0] = -1;
    for (int i = 1; i < arr.length; i++) {
      while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
        st.pop();
      }

      if (st.size() == 0) {
        lb[i] = -1;
      } else {
        lb[i] = st.peek();
      }

      st.push(i);
    }
    return lb;

    }
    public int[] smallerOnRight(int[] arr){
        
    int[] rb = new int[arr.length]; // nse on the right
    Stack<Integer> st = new Stack<>();

    st.push(arr.length - 1);
    rb[arr.length - 1] = arr.length;
    for (int i = arr.length - 2; i >= 0; i--) {
      while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
        st.pop();
      }

      if (st.size() == 0) {
        rb[i] = arr.length;
      } else {
        rb[i] = st.peek();
      }

      st.push(i);
    }
    return rb;
    }
}