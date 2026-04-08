class Solution {
    public int change(int amount, int[] coins) {
//        return recursiveHelper(coins, amount, 0);

        int[][] cache = new int[coins.length][amount+1];
        for (int[] row: cache){
            Arrays.fill(row,-1);
        }

        return topDownHelper(coins,amount,0,cache);
    }

    private int topDownHelper(int[] coins, int target, int index, int[][] cache) {
        if (target == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }
        if (cache[index][target] != -1) {
            return cache[index][target];
        }

        int ignoreCase = topDownHelper(coins, target, index + 1, cache);

        int includeCase = 0;
        if (target - coins[index] >= 0) {
            includeCase = topDownHelper(coins, target - coins[index], index, cache);
        }

        cache[index][target] = includeCase + ignoreCase;

        return cache[index][target];
    }
}
