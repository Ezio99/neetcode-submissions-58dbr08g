class Solution {
    public int[] productExceptSelf(int[] nums) {
                int zeroCount=0,zeroLocation=0;
        int[] output = new int[nums.length];
        int product = 1;
        for(int i =0;i< nums.length; i++){
            if(nums[i]==0){
                zeroCount++;
                zeroLocation=i;
                if(zeroCount==2){
                    break;
                }
            }
            else{
                product*=nums[i];
            }

        }

        if(zeroCount==0){
            int ctr=0;
            for(int i : nums){
                output[ctr] = product/i;
                ctr++;
            }
        } else if (zeroCount==1) {
            for (int i = 0; i < nums.length; i++) {
                output[i] = 0;
            }
            output[zeroLocation] = product;

        }
        else{
            for (int i = 0; i < nums.length; i++) {
                output[i] = 0;
            }
        }

        return output;
    }
}  
