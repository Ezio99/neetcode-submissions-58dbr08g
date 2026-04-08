class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
                int[][] cache = new int[profit.size()][capacity + 1];
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }
        return helper(profit, weight, capacity, 0, cache);
    }

    private int helper(List<Integer> profit, List<Integer> weight, int currentCapacity, int ctr, int[][] cache) {
        if (ctr == weight.size()) {
            return 0;
        }
        if (cache[ctr][currentCapacity] != -1) {
            return cache[ctr][currentCapacity];
        }

        int skipVal = helper(profit, weight, currentCapacity, ctr + 1, cache);
        int includeVal = 0;

        if (currentCapacity - weight.get(ctr) >= 0) {
            includeVal = profit.get(ctr) + helper(profit, weight, currentCapacity - weight.get(ctr), ctr, cache);
        }

        cache[ctr][currentCapacity] = Math.max(skipVal, includeVal);

        return cache[ctr][currentCapacity];


    }
}
