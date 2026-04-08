class Solution {
    public int numDistinct(String s, String t) {
        return recursiveHelper(s,t,0,0);
    }

    private int recursiveHelper(String s, String t, int i1, int i2) {
        if (i2 == t.length()) {
            return 1;
        }
        if (i1 == s.length()) {
            return 0;
        }

        int ctr = 0;
        if (s.charAt(i1) == t.charAt(i2)) {
            ctr = recursiveHelper(s, t, i1 + 1, i2 + 1);
        }

        ctr += recursiveHelper(s, t, i1 + 1, i2);

        return ctr;
    }
}
