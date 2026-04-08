class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
        return bottomUpHelper(text1,text2);
    }

    private int bottomUpHelper(String text1, String text2) {
        int[] prev = new int[text1.length() + 1];
        int[] dp;

        for (int i = 0; i < text2.length(); i++) {
            dp = new int[text1.length() + 1];
            for (int j = 0; j < text1.length(); j++) {
                if (text2.charAt(i) == text1.charAt(j)) {
                    dp[j + 1] = 1 + prev[j];
                } else {
                    dp[j + 1] = Math.max(prev[j + 1], dp[j]);
                }
            }
            prev = dp;
        }

        return prev[text1.length()];
    }
}
