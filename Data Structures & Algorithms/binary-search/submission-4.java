class Solution {
  public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid = (r+l) / 2;
        while (l <= r) {
            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }


            mid = (r+l) / 2;
        }

        return -1;
    }
}
