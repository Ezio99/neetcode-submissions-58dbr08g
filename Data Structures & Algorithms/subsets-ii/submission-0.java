class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        helper_2(0, nums, curr, result);

        return result;
    }

    public void helper_2(int i, int[] nums, List<Integer> curr, List<List<Integer>> result) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }


        curr.add(nums[i]);
        helper_2(i + 1, nums, curr, result);

        curr.remove(curr.size()-1);
        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1]) {
                i++;
            } else {
                break;
            }

        }
        helper_2(i + 1, nums, curr, result);


    }
}
