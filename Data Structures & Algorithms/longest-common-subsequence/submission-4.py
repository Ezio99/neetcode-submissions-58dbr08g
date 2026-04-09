class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        N = len(text1)
        M = len(text2)
        cache = [[-1] * (M+1) for _ in range(0,N+1)]

        def dfs(i1: int,i2: int) -> int:
            if i1>= len(text1) or i2>=len(text2):
                return 0
            if cache[i1][i2]!=-1:
                return cache[i1][i2]
            
            if text1[i1] == text2[i2]:
                cache[i1][i2] = 1+ dfs(i1+1,i2+1)
            else:
                cache[i1][i2] = max(dfs(i1+1,i2),dfs(i1,i2+1))
            
            return cache[i1][i2]
        
        return dfs(0,0)