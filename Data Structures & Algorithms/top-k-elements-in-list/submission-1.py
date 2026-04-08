class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map = defaultdict(int)
        for i in nums:
            map[i] += 1
        h = []
        for i in map.keys():
            h.append((-1 * map.get(i),i))
        heapq.heapify(h)
        print(h)
        ans=[]
        for i in range(k):
            ans.append(heapq.heappop(h)[1])
        return ans
        
