class Solution {
   public int maxProfit(int[] prices) {
        int profit = 0, minBuyTillNow = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minBuyTillNow > profit) {
                profit = prices[i] - minBuyTillNow;
            }
            if (prices[i] < minBuyTillNow) {
                minBuyTillNow = prices[i];
            }
        }
        
        return profit;
    }
}
