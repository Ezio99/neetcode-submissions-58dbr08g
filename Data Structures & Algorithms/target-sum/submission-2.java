class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int[][] cache = new int[nums.length][target + 2001];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(cache[i], -1);
        }

        return dfsHelper(0, nums, target, cache);
    }

    private int dfsHelper(int i, int[] nums, int target, int[][] cache) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        if (cache[i][target + 1000] != -1) {
            return cache[i][target + 1000];
        }

        cache[i][target + 1000] = dfsHelper(i + 1, nums, target + nums[i], cache) +
                dfsHelper(i + 1, nums, target - nums[i], cache);

        return cache[i][target + 1000];
    }
}
