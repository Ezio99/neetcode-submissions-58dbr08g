class Solution {
   public boolean canJump(int[] nums) {
        int[] cache = new int[nums.length];
        return dfs(0, nums, cache) == 1;
    }

    public int dfs(int i, int[] nums, int[] cache) {
        if (i == nums.length - 1) {
            return 1;
        }
        if (i >= nums.length) {
            return -1;
        }
        if (cache[i] != 0) {
            return cache[i];
        }


        int isExist = -1;
        for (int j = 1; j <= nums[i]; j++) {
            if (dfs(i + j, nums, cache) == 1) {
                isExist = 1;
                break;
            }
        }

        cache[i] = isExist;

        return cache[i];
    }
}
