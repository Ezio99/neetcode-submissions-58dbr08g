class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length,sum=0;
        for (int i = 1; i <= n; i++) {
            sum+=i;
        }
        
        for (int i: nums){
            sum-=i;
        }

        return sum;
    }
}
