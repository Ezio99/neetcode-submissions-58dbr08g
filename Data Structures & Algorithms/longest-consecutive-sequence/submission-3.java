class Solution {
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxLength = 1, length, curr;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] + 1) && !set.contains(nums[i] - 1)) {
                length = 1;
                curr = nums[i];
                while (set.contains(curr + 1)) {
                    length++;
                    curr++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
