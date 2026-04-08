class Solution {
     public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0) return false;
        int target = totalSum / 2;
//        int[][] cache = new int[nums.length][target + 1];
//        return dfs(0, nums, target, cache);
        
        return bottomUpHelper(nums,target);

    }

    public boolean bottomUpHelper(int[] nums, int target) {
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;

        for (int i = 0; i < nums.length; i++) {
            boolean[] dp = new boolean[target + 1];
            for (int j = 1; j <= target; j++) {
                dp[j] = prev[j] || (j - nums[i] >= 0 && prev[j - nums[i]]);
            }
            prev = dp;

        }

        return prev[target];


    }
}
