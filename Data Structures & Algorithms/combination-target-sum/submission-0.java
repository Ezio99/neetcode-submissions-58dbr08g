class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, target, result, new ArrayList<>());

        return result;
    }

     private void helper(int i, int[] nums, int target, List<List<Integer>> result, List<Integer> currentCombination) {
        int val = currentCombination.stream().reduce(0, Integer::sum);
        if (val > target) {
            return;
        }
        if (val == target) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }


        while (i < nums.length) {
            if (nums[i] + val <= target) {
                currentCombination.add(nums[i]);
                helper(i,nums,target,result,currentCombination);
                currentCombination.remove(currentCombination.size()-1);
            }
            else{
                //Since nums is sorted if this val is greater than target then the next one will also not be
                break;
            }
            i++;
        }


    }
}
