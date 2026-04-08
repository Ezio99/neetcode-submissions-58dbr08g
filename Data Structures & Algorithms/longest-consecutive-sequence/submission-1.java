class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length==0){
            return 0;
        }
                Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int maxSize = 1, currentSize, ctr;
//        HashMap<Integer, ArrayDeque<Integer>> consecutiveNumbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!numSet.contains(nums[i] - 1)) {
                currentSize = 1;
                ctr = 1;
                while (true) {
                    if (numSet.contains(nums[i] + ctr)) {
                        currentSize++;
                        ctr++;
                    } else {
                        break;
                    }
                }
                if(currentSize>maxSize){
                    maxSize=currentSize;
                }
            }
        }

        return maxSize;
    }
}
