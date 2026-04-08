class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length()][text2.length()];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfsHelper(0, 0, text1, text2, cache);
    }

    private int dfsHelper(int i1, int i2, String text1, String text2, int[][] cache) {
        if (i1 == text1.length() || i2 == text2.length()) return 0;

        if (cache[i1][i2] != -1) {
            return cache[i1][i2];
        }

        if (text1.charAt(i1) == text2.charAt(i2)) {
            cache[i1][i2] = 1 + dfsHelper(i1 + 1, i2 + 1, text1, text2, cache);
        } else {
            cache[i1][i2] = Math.max(dfsHelper(i1 + 1, i2, text1, text2, cache), dfsHelper(i1, i2 + 1, text1, text2, cache));
        }
        
        return cache[i1][i2];
    }
}
