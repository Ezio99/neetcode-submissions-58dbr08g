class Solution {
  public int countSubstrings(String s) {
        int l, r, ctr = 0;

        for (int i = 0; i < s.length(); i++) {
            l = r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                ctr++;
                l--;
                r++;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                ctr++;
                l--;
                r++;
            }
        }

        return ctr;
    }
}
