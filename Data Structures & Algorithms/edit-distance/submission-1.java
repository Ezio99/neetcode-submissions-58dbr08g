class Solution {
   public int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfsHelper(0, 0, word1, word2, cache);
    }

    public int dfsHelper(int i1, int i2, String word1, String word2, int[][] cache) {
        if (i1 == word1.length() || i2 == word2.length()) {
            return (word1.length() - i1) + (word2.length() - i2);
        }

        if (cache[i1][i2] != -1) return cache[i1][i2];

        if (word1.charAt(i1) == word2.charAt(i2)) {
            return cache[i1][i2] = dfsHelper(i1 + 1, i2 + 1, word1, word2, cache);
        }

        int delete = dfsHelper(i1 + 1, i2, word1, word2, cache);
        int insert = dfsHelper(i1, i2 + 1, word1, word2, cache);
        int replace = dfsHelper(i1 + 1, i2 + 1, word1, word2, cache);

        cache[i1][i2] = 1 + Math.min(delete, Math.min(insert, replace));

        return cache[i1][i2];
    }
}
