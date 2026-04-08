class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map = defaultdict(int)
        for i in nums:
            map[i] += 1
        h = [(map.get(i),i) for i in map.keys()]
        heapq.heapify(h)
        ans = [i[1] for i in heapq.nlargest(k,h)]
        return ans
        
