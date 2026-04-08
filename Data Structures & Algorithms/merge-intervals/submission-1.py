class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key= lambda x: (x[0], x[1]))
        ans = []
        n = len(intervals)
        ans.append(intervals[0])
        ctr=0
        for i in range(1,n):
            if ans[ctr][1] >= intervals[i][0]:
                ans[ctr][1] = max(ans[ctr][1],intervals[i][1])
            else:
                ans.append(intervals[i])
                ctr+=1 

        return ans
