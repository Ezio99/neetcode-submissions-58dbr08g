class Solution {
      public  List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        helper(0, nums, target, result, new ArrayList<>());

        return result;
    }

    private  void helper(int i, int[] nums, int target, List<List<Integer>> result, List<Integer> currentCombination) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }


        while (i < nums.length) {
            if (target - nums[i] >= 0) {
                currentCombination.add(nums[i]);
                helper(i, nums, target - nums[i], result, currentCombination);
                currentCombination.remove(currentCombination.size()-1);
            } else {
                //Since nums is sorted if this val is greater than target then the next one will also not be
                break;
            }
            i++;
        }


    }
}
