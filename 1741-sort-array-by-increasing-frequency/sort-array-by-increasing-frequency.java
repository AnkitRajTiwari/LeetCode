class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Create a HashMap to store frequencies of each number
        Map<Integer, Integer> map = new HashMap<>();

        // Step 2: Count frequency of each element
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // If number already exists in map, increment its count
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                // If number is not in map, add it with count 1
                map.put(nums[i], 1);
            }
        }

        // Step 3: Create a list from the keys of the map (i.e., unique numbers)
        List<Integer> list = new ArrayList<>(map.keySet());

        // Step 4: Sort the list based on frequency in ascending order
        // If frequencies are the same, sort based on value in descending order
        Collections.sort(list, (a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return b - a; // higher value first if frequency is same
            } else {
                return map.get(a) - map.get(b); // lower frequency first
            }
        });

        // Step 5: Create the result array of same size as original array
        int[] result = new int[nums.length];
        int index = 0;

        // Step 6: Build result array using sorted list and frequency
        for (int num : list) {
            for (int i = 0; i < map.get(num); i++) {
                result[index++] = num;
            }
        }

        return result;
    }
}
