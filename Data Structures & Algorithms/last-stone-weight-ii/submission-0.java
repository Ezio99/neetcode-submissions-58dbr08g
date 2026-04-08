class Solution {
    //We want to create 2 sets of roughly equal stones so that smashing them leads to 0 or close to it
    //So we want to find a pile of stones which is as close to the midpoint as possible
    public int lastStoneWeightII(int[] stones) {
        int totalSum = Arrays.stream(stones).sum();
        int target = totalSum / 2;
        int[][] cache = new int[stones.length][target + 1];
        int bestWeight = dfsHelper(0, stones, target, cache);


        return Math.abs((totalSum - bestWeight) - bestWeight);
    }

    private int dfsHelper(int i, int[] stones, int target, int[][] cache) {
        if (target == 0 || i == stones.length) {
            return 0;
        }
        if (cache[i][target] != 0) {
            return cache[i][target];
        }

        int ignore = dfsHelper(i + 1, stones, target, cache);
        int include = 0;
        if (target - stones[i] >= 0) {
            include = stones[i] + dfsHelper(i + 1, stones, target - stones[i], cache);
        }

        cache[i][target] = Math.max(include, ignore);
        return cache[i][target];
    }
}