class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }

            //If left array is sorted
            if(nums[l]<=nums[m]){
                //If target in left array
                if(nums[l]<=target && target<nums[m]){
                    r=m-1;
                }
                else{
                    l=m+1;
                }
            }
            //If right array is sorted
            else{
                //If target in right array
                if(target<=nums[r] && target>nums[m]){
                    l=m+1;
                }
                else{
                    r=m-1;
                }
            }
        }

        return nums[m] == target ? m : -1;
    }
}