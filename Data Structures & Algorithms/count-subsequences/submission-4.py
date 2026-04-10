class Solution:
    def numDistinct(self, s: str, t: str) -> int:

        N = len(s)
        M = len(t)

        prev = [1] * (N+1)

        for i in range(1,M+1):
            dp = [0] * (N+1)
            for j in range(1,N+1):
                skip = dp[j-1]
                include = prev[j-1] if t[i-1]==s[j-1] else 0
                dp[j] = skip+include
            prev=dp
        return prev[-1]
        
        # def dfs(i1: int,i2:int) -> int:
        #     if i2==len(t):
        #         return 1
        #     if i1==len(s):
        #         return 0
        #     if (i1,i2) in cache:
        #         return cache[(i1,i2)]
            
        #     skip = dfs(i1+1,i2)

        #     include = 0
        #     if s[i1]==t[i2]:
        #         include = dfs(i1+1,i2+1)
            
        #     cache[(i1,i2)] =  skip+include
        #     return cache[(i1,i2)]
        
        # return dfs(0,0)