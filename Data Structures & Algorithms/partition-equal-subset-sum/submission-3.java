class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0) return false;
        int target = totalSum / 2;
        int[][] cache = new int[nums.length][target + 1];


        return dfs(0, nums, target, cache);

    }

    private boolean dfs(int i, int[] nums, int target, int[][] cache) {
        if (target == 0) return true;
        if (target < 0 || i == nums.length) return false;

        if (cache[i][target] != 0) {
            return cache[i][target] == 1;
        }


        cache[i][target] = (dfs(i + 1, nums, target, cache) || dfs(i + 1, nums, target - nums[i], cache)) ? 1 : -1;
        
        return cache[i][target] == 1;
    }
}
