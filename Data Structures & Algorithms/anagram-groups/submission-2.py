class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = defaultdict(list)
        ans=[]
        for word in strs:
            x = "".join(sorted(word))
            map[x].append(word)
        
        for words in map.values():
            ans.append(words)
        print(ans)

        return ans