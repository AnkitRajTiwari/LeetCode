class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;
        int answer = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        // Prefix sum
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int end = 0; end <= n; end++) {

            // Check if sum >= k
            while (!deque.isEmpty()) {

                int start = deque.peekFirst();

                long sum = prefix[end] - prefix[start];

                if (sum < k) {
                    break;
                }

                answer = Math.min(answer, end - start);

                deque.pollFirst();
            }

            // Remove useless prefix indexes
            while (!deque.isEmpty()) {

                int last = deque.peekLast();

                if (prefix[last] >= prefix[end]) {
                    deque.pollLast();
                } else {
                    break;
                }
            }

            // Add current prefix index
            deque.offerLast(end);
        }

        if (answer == n + 1) {
            return -1;
        }

        return answer;
    }
}