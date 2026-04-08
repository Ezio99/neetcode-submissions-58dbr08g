class Solution {
  //We want to create 2 sets of roughly equal stones so that smashing them leads to 0 or close to it
    //So we want to find a pile of stones which is as close to the midpoint as possible
    public int lastStoneWeightII(int[] stones) {
        int totalSum = Arrays.stream(stones).sum();
        int target = totalSum / 2;
//        int[][] cache = new int[stones.length][target + 1];
//        int bestWeight2 = dfsHelper(0, stones, target, cache);
        int bestWeight = bottomUpHelper(stones, target);

        return Math.abs((totalSum - bestWeight) - bestWeight);
    }

    private int bottomUpHelper(int[] stones, int target) {
        boolean[] prev = new boolean[target + 1];
        boolean[] dp;
        prev[0] = true;

        for (int i = 0; i < stones.length; i++) {
            dp = new boolean[target + 1];
//            dp[0] = true;
            //Either do above or set j=0 so that the 0 column being true perpetuates
            //Otherwise later on we set true a number which is equal to j (j - stones[i] results in prev[0] which if not set is default false)
            for (int j = 0; j <= target; j++) {
                dp[j] = prev[j] || (j - stones[i] >= 0 && prev[j - stones[i]]);
            }
            prev = dp;
        }

        for (int i = target; i >= 0; i--) {
            if (prev[i]) return i;
        }

        return 0;
    }
}