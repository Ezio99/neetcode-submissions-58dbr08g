class Solution {
   public int maxProduct(int[] nums) {
        int currMax = nums[0], currMin = nums[0], result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmpMax = currMax;
            currMax = Math.max(nums[i], Math.max(nums[i] * currMax, nums[i] * currMin));
            currMin = Math.min(nums[i], Math.min(nums[i] * tmpMax, nums[i] * currMin));

            result=Math.max(currMax,result);
        }

        return result;
    }
}
