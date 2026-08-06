class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        /////// since we have to find the index here so we have to use the IntStream
       List<Integer> indexes = IntStream.range(0, nums.length)
        .filter(i -> nums[i] == x)
        .boxed()
        .collect(Collectors.toList());

int[] result = Arrays.stream(queries)
        .map(q -> q <= indexes.size() ? indexes.get(q - 1) : -1)
        .toArray();

return result;
    }
}