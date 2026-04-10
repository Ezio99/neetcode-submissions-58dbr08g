class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:

        cache={}
        
        def dfs(i: int) -> int:
            if i>=len(nums):
                return 0
            if i in cache:
                return cache[i]
            
            

            include=1
            for j in range(i+1,len(nums)):
                if nums[j]>nums[i]:
                    include = max(include,1+dfs(j))
            cache[i] = include

            return cache[i]
        
        result=0
        for i in range(0,len(nums)):
            result =max(result,dfs(i))
        return result
