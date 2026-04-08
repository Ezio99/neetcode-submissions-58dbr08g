class Solution {
    public int coinChange(int[] coins, int amount) {
//        return recursiveHelper(coins, amount, 0);

        int[][] cache = new int[coins.length][amount+1];
        
        return topDownHelper(coins,amount,0,cache);

    }

    private int topDownHelper(int[] coins, int targetAmount, int i, int[][] cache) {
        if (targetAmount == 0) {
            return 0;
        }
        if (i == coins.length) {
            return -1;
        }
        if (cache[i][targetAmount] != 0) {
            return cache[i][targetAmount];
        }

        int ignoreCase = topDownHelper(coins, targetAmount, i+1, cache);
        int keepCase = 0;

        if (targetAmount - coins[i] >= 0) {
            keepCase = topDownHelper(coins, targetAmount - coins[i], i, cache);
            if (keepCase != -1) {
                keepCase++;
            }
        }

        if (ignoreCase * keepCase < 0) {
            cache[i][targetAmount] = Math.max(ignoreCase, keepCase);
        } else {
            cache[i][targetAmount] = Math.min(ignoreCase, keepCase);
        }

        return cache[i][targetAmount];

    }
}
