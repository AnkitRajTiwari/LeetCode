class Solution {
    public int[] arrayChange(int[] nums, int[][] operations)
     {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
         {
            map.put(nums[i], i);
        }
        for (int[] op : operations) {
            int oldVal = op[0], newVal = op[1];
            if (map.containsKey(oldVal))
             {
                int index = map.get(oldVal);
                nums[index] = newVal;
                map.remove(oldVal);
                map.put(newVal, index);
            }
        }
        return nums;
    }
}

/*
class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        for (int i = 0; i < operations.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (operations[i][0] == nums[j]) {
                    nums[j] = operations[i][1];
                    break;
                }
            }
        }
        return nums;
    }
}
*/