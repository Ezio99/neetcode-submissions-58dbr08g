class Solution:
    def climbStairs(self, n: int) -> int:
        cache = [0 for i in range(n)]
        return self.dfs(0,n,cache)

    def dfs(self, i: int,n: int,cache: List[int]) -> int:
        if(i==n):
            return 1
        if(i>n):
            return 0
        if(cache[i]!=0):
            return cache[i]
        
        cache[i] = self.dfs(i+1,n,cache) + self.dfs(i+2,n,cache)

        return cache[i]