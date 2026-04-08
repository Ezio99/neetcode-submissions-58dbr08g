class Solution {
    public int coinChange(int[] coins, int amount) {
         return recursiveHelper(coins,amount,0);
    }

        private int recursiveHelper(int[] coins, int targetAmount, int i) {
        if (targetAmount == 0) {
            return 0;
        }
        if (i == coins.length) {
            return -1;
        }

        int ignoreCase = recursiveHelper(coins, targetAmount, i + 1);
        int keepCase = 0;
        if (targetAmount - coins[i] >= 0) {
            keepCase = recursiveHelper(coins, targetAmount - coins[i], i);
            if (keepCase != -1) {
                keepCase += 1;
            }
        }

        if (keepCase * ignoreCase < 0) {
            return Math.max(keepCase, ignoreCase);
        }

        return Math.min(ignoreCase, keepCase);


    }
}
