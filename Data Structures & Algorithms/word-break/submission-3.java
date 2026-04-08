class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int[] cache = new int[s.length()];
        return dfs(0, 0, s, set, cache) == 1;
    }

    public int dfs(int l, int r, String s, HashSet<String> set, int[] cache) {
        if (r >= s.length()) {
            return -1;
        }
        if (cache[l] != 0) {
            return cache[l];
        }

        int ignore = dfs(l, r + 1, s, set, cache);
        int keep = -1;

        if (set.contains(s.substring(l, r + 1))) {
            if (r == s.length() - 1) {
                return 1;
            } else {
                keep = dfs(r + 1, r + 1, s, set, cache);
            }
        }

        cache[l] = Math.max(keep, ignore);

        return cache[l];

    }
}
