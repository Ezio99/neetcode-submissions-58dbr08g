class Solution {
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return dfsBackTrack(s, 0, cache);
    }

    public int dfsBackTrack(String s, int i, int[] cache) {
        if (i == s.length()) {
            return 1;
        }
        if (cache[i] != -1) {
            return cache[i];
        }


        int numChoices = 0;
        int res = s.charAt(i) - '0';

        if (res >= 1) {
            numChoices += dfsBackTrack(s, i + 1, cache);
        } else {
            //Cant consider the case where 0 is a leading number
            return 0;
        }

        if (i + 1 < s.length()) {
            res = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0';
            if (res <= 26) {
                numChoices += dfsBackTrack(s, i + 2, cache);
            }
        }

        cache[i] = numChoices;

        return cache[i];
    }
}
