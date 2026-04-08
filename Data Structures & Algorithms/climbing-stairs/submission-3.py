class Solution:
    def climbStairs(self, n: int) -> int:
        if(n==2 or n==1):
            return n
        cache = [0 for i in range(n+1)]
        cache[n-1]=1
        cache[n]=1
        for i in range(n-2,-1,-1):
            cache[i] = cache[i+1]+cache[i+2]

        return cache[0]
            