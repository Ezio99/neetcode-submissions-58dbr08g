class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(nums.length - 1, nums[nums.length - 1]);
        robHelper(0, nums, 0, cache);
        return cache.get(0);
    }

    public int robHelper(int i, int[] nums, int robbedSoFar, HashMap<Integer, Integer> cache){
        if (i >= nums.length) {
            return robbedSoFar;
        } else if (cache.get(i) != null) {
            return cache.get(i);
        }

        cache.put(i, Math.max(nums[i] + robHelper(i + 2, nums, robbedSoFar, cache),
                robHelper(i + 1, nums, robbedSoFar, cache)));
        return cache.get(i);
    }
}
