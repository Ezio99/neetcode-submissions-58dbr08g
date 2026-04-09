class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        N = len(text1)
        M = len(text2)
        prev = [0] * (M+1)

        for i in range(1,N+1):
            dp = [0] * (M+1)
            for j in range(1,M+1):
                if text1[i-1]==text2[j-1]:
                    dp[j] = 1+ prev[j-1]
                else:
                    dp[j] = max(prev[j],dp[j-1])
            prev=dp

        print(prev)
        return prev[-1]
        

        # def dfs(i1: int,i2: int) -> int:
        #     if i1>= len(text1) or i2>=len(text2):
        #         return 0
        #     if cache[i1][i2]!=-1:
        #         return cache[i1][i2]
            
        #     if text1[i1] == text2[i2]:
        #         cache[i1][i2] = 1+ dfs(i1+1,i2+1)
        #     else:
        #         cache[i1][i2] = max(dfs(i1+1,i2),dfs(i1,i2+1))
            
        #     return cache[i1][i2]
        
       