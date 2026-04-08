class Solution {
  public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int l = 0, ctr = 0;

        for (int r = 1; r < nums.length; r++) {
            if (nums[l] != nums[r]) {
                nums[++ctr] = nums[r];
                l = r;
            }
        }

        return ctr +1;
    }
}