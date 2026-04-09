class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        curr = prices[0]
        profit = 0
        for i in range(1,n):
            if prices[i]>curr:
                profit += prices[i]-curr 
            curr = prices[i]
        return profit