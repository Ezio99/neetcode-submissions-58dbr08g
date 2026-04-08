class Solution {
 public int findTargetSumWays(int[] nums, int target) {
//        return recursiveHelper(nums,target,0);

        //Given max sum of all nums is 1000, so if we made them all -ve and added them they will be bounded by -1000
        //But our array is relative to the target itself like we are bounded by target + sum(nums)
        int[][] cache = new int[nums.length][2001 + target];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(cache[i], -1);
        }


        return topDownHelper(nums, target, 0, cache);
    }

    private int topDownHelper(int[] nums, int target, int i, int[][] cache) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        if (cache[i][target + 1000] != -1) {
            return cache[i][target + 1000];
        }

        cache[i][target + 1000] = topDownHelper(nums, target + nums[i], i + 1, cache) +
                topDownHelper(nums, target - nums[i], i + 1, cache);

        return cache[i][target + 1000];

    }
}
