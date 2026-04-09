class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        n = len(nums)
        dp1 = [0]*(n+1)
        dp2 = [0]*(n+1)

        dp1[n-1]=nums[n-1]

        for i in range(n-2,0,-1):
            dp1[i] = max(dp1[i+1],nums[i]+dp1[i+2])
        

        dp2[n-2]=nums[n-2]
        for i in range(n-3,-1,-1):
            dp2[i] = max(dp2[i+1],nums[i]+dp2[i+2])
        

        return max(dp1[1],dp2[0])

        
