class Solution {
  public int change(int amount, int[] coins) {
        int[][] cache = new int[coins.length][amount + 1];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfsHelper(0, coins, amount, cache);
    }

    private int dfsHelper(int i, int[] coins, int amount, int[][] cache) {
        if (amount == 0) {
            return 1;
        }
        if (i == coins.length) {
            return 0;
        }
        if (cache[i][amount] != -1) {
            return cache[i][amount];
        }


        int skip = 0;
        skip += dfsHelper(i + 1, coins, amount, cache);

        int take = 0;
        if (amount - coins[i] >= 0) {
            take += dfsHelper(i, coins, amount - coins[i], cache);
        }

        cache[i][amount] = take + skip;

        return cache[i][amount];
    }
}
