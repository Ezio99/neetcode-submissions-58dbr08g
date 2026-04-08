class Solution {
    public int change(int amount, int[] coins) {
//        int[][] cache = new int[coins.length][amount + 1];
//        for (int i = 0; i < cache.length; i++) {
//            Arrays.fill(cache[i], -1);
//        }
//        return dfsHelper(0, coins, amount, cache);

        return bottomUpHelper(amount, coins);
    }

    private int bottomUpHelper(int amount, int[] coins) {
        int[] prev = new int[amount + 1];
        int[] dp;
        prev[0] = 1;

        int skip, include;
        for (int i = 0; i < coins.length; i++) {
            dp = new int[amount + 1];
            for (int j = 0; j <= amount; j++) {
                skip = prev[j];
                include = 0;
                if (j - coins[i] >= 0) include = dp[j - coins[i]];
                dp[j] = skip + include;
            }
            prev = dp;
        }

        return prev[amount];
    }
}
