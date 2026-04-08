class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        ans=[]
        nums.sort()
        n = len(nums)
        for i in range(0,n):
            if i>0 and nums[i]==nums[i-1]:
                continue
            target=-1*nums[i]
            left = i+1
            right = n-1
            while right>left:
                sum = nums[left]+nums[right]
                if sum>target:
                    right-=1
                elif sum<target:
                    left+=1
                else:
                    ans.append([nums[i],nums[left],nums[right]])
                    while left<right and nums[left]==nums[left+1]:
                        left+=1
                    left+=1
                    while right>left and nums[right]==nums[right-1]:
                        right-=1
                    right-=1
        return ans

