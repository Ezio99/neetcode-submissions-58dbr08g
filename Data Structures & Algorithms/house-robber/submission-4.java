class Solution {
  public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs(nums, 0, cache);
    }

    public int dfs(int[] nums, int i, int[] cache) {
        if (i >= nums.length) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }

        int skip = dfs(nums, i + 1, cache);

        int keep = nums[i] + dfs(nums, i + 2, cache);

        return cache[i] = Math.max(skip, keep);
    }
}
