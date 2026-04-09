class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        cache: dict[tuple[int,bool],int] = {}

        def dfs(i: int, bought: bool) -> int:
            if i==len(prices):
                return 0
            if (i,bought) in cache:
                return cache[(i,bought)]
            
            skip = dfs(i+1,bought)
            include = 0
            if bought:
                include = prices[i] + dfs(i+1,False)
            else:
                include = -prices[i] + dfs(i+1,True)
            
            cache[(i,bought)] = max(skip,include)

            return cache[(i,bought)]
        
        return dfs(0,False)



