public class Solution{
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;                  // Pointer for placing even numbers
        int right = nums.length - 1;  // Pointer for placing odd numbers

        int[] result = new int[nums.length];  // New array to store sorted result

        for (int num : nums) {
            if (num % 2 == 0) {
                result[left++] = num;  // Place even numbers from the front
            } else {
                result[right--] = num; // Place odd numbers from the back
            }
        }

        return result;
    }
}
