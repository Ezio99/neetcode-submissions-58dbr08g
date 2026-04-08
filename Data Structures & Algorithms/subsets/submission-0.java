class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        helper(0, nums, curr, result);

        return result;
    }


    public void helper(int i, int[] nums, List<Integer> curr, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        helper(i + 1, nums, curr, result);

        curr.remove(curr.size()-1);
        helper(i + 1, nums, curr, result);
    }
}
