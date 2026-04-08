class Solution:
    def maxArea(self, heights: List[int]) -> int:
        maxWater=0
        left = 0
        right = len(heights)-1

        while(left<right):
            maxWater = max(maxWater,min(heights[left],heights[right])*(right -left))
            if(heights[right]>=heights[left]):
                left+=1
            else:
                right-=1
        return maxWater