class Solution {
  public int lengthOfLIS(int[] nums) {
        int[][] cache = new int[nums.length][2001];
        for(int[] arr:cache){
            Arrays.fill(arr,-1);
        }
        return dfs(nums, 0, -1001,cache);
    }

    public int dfs(int[] nums, int i, int val,int[][] cache) {
        if (i == nums.length) {
            return 0;
        }
        if(cache[i][val+1001]!=-1){
            return cache[i][val+1001];
        }

        int skip = dfs(nums, i + 1, val,cache);

        int keep = 0;
        if (nums[i] > val) {
            keep = 1 + dfs(nums, i + 1, nums[i],cache);
        }

        cache[i][val+1001] = Math.max(skip, keep);

        return cache[i][val+1001];
    }
}
