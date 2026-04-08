class Solution {
  public int rob(int[] nums) {
        int n = nums.length;
             if (n == 1) {
            return nums[0];
        }
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        int keepFirst = dfs(nums, 0, n - 1, cache);
        Arrays.fill(cache, -1);
        int dont = dfs(nums, 1, n, cache);
        return Math.max(keepFirst, dont);
    }

    public int dfs(int[] nums, int i, int end, int[] cache) {
        if (i >= end) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }

        int skip = dfs(nums, i + 1, end, cache);

        int keep = nums[i] + dfs(nums, i + 2, end, cache);

        return cache[i] = Math.max(skip, keep);
    }
}
