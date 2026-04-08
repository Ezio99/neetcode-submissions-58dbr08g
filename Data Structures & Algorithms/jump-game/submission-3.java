class Solution {
    //Greedy
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            //If my index plus max I can jump can reach or surpass goal then reaching me means you can reach the goal
            //So Im the new goal
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        //If the goal is 0 it means reaching 0 means you can reach n-1
        return goal == 0;
    }
}
