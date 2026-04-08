class Solution {

     int totalSum;
     int targetSum;
    public boolean canPartition(int[] nums) {
        totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0) {
            return false;
        }
        targetSum = totalSum / 2;

        return helper(nums, 0, 0);

    }

    private boolean helper(int[] nums, int i, int currentSum) {
        if (i >= nums.length) {
            return false;
        }
        //All positive so can only increase so will never be equal
        if (currentSum > targetSum) {
            return false;
        }

        if (currentSum == targetSum) {
            return true;
        }

        return helper(nums, i + 1, currentSum) || helper(nums, i + 1, currentSum + nums[i]);

    }
}
