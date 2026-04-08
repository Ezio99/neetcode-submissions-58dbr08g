class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            if (!set.add(nums[r])) {
                return true;
            }

            if (r - l== k) {
                set.remove(nums[l]);
                l++;
            }
        }
        return false;
    }
}