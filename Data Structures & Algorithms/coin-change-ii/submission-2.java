class Solution {
    public int change(int amount, int[] coins) {
//        return recursiveHelper(coins, amount, 0);

//        int[][] cache = new int[coins.length][amount + 1];
//        for (int[] row : cache) {
//            Arrays.fill(row, -1);
//        }
//
//        return topDownHelper(coins, amount, 0, cache);

        return bottomUpHelper(coins, amount);
    }

    private int bottomUpHelper(int[] coins, int amount) {
        //Number of ways to get the target
        int[] prevRow = new int[amount + 1];
        //For coin of value 0 number of ways to get amount 0 is 1
        prevRow[0] = 1;

        int skipCase, includeCase;
        for (int i = 0; i < coins.length; i++) {
            int[] currentRow = new int[amount + 1];
            for (int j = 0; j <= amount; j++) {
                skipCase = prevRow[j];
                includeCase = 0;
                if (j - coins[i] >= 0) {
                    includeCase = currentRow[j - coins[i]];
                }
                currentRow[j] = skipCase + includeCase;
            }
            prevRow = currentRow;
        }

        return prevRow[amount];

    }
}
