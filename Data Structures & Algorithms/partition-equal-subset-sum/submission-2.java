class Solution {

     int totalSum;
     int targetSum;
    public boolean canPartition(int[] nums) {
         totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0) {
            return false;
        }
        targetSum = totalSum / 2;

        int[][] cache = new int[nums.length][totalSum];

        return topDownHelper(nums,0,0,cache);

    }

        private  boolean topDownHelper(int[] nums, int i, int currentSum, int[][] cache) {
        if (i >= nums.length) {
            return false;
        }
        if (currentSum > targetSum) {
            return false;
        }
        if (currentSum == targetSum) {
            return true;
        }
        if (cache[i][currentSum] == -1) {
            return false;
        }


        cache[i][currentSum] = -1;

        return topDownHelper(nums, i + 1, currentSum, cache) || topDownHelper(nums, i + 1, currentSum + nums[i], cache);


    }
}
