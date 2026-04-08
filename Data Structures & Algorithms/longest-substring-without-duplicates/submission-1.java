class Solution {
   public int lengthOfLongestSubstring(String s) {
        int maxCtr = 0, l = 0;
        HashSet<Character> set = new HashSet<>();

        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));

            maxCtr = Math.max(r - l + 1, maxCtr);
        }

        return maxCtr;
    }
}
