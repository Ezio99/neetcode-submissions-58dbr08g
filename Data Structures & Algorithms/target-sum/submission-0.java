class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recursiveHelper(nums,target,0);
    }

        private int recursiveHelper(int[] nums, int target,int i) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }


        return recursiveHelper(nums,  target + nums[i],i + 1) +
                recursiveHelper(nums,  target - nums[i],i + 1);

    }
}
