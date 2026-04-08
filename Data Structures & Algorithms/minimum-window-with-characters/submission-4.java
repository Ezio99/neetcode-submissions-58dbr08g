class Solution {
   public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] minWindow = new int[]{0, Integer.MAX_VALUE};
        HashMap<Character, Integer> characterMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            characterMap.merge(t.charAt(i), 1, Integer::sum);
        }

        for (int l = 0; l < s.length(); l++) {
            if (characterMap.containsKey(s.charAt(l))) {
                HashMap<Character, Integer> copy = new HashMap<>(characterMap);
                int ctr = 0;
                int r;
                char ch;
                for (r = l; r < s.length(); r++) {
                    ch = s.charAt(r);
                    if (copy.containsKey(ch) && copy.get(ch) > 0) {
                        copy.put(ch, copy.get(ch) - 1);
                        ctr++;
                        if (ctr == t.length()) {
                            break;
                        }
                    }
                }
                if (ctr < t.length() && minWindow[1] == Integer.MAX_VALUE) {
                    return "";
                }
                if (ctr == t.length() && r - l + 1 < minWindow[1] - minWindow[0]) {
                    minWindow[0] = l;
                    minWindow[1] = r + 1;
                }
            }
        }

        return minWindow[1] == Integer.MAX_VALUE ? "" : s.substring(minWindow[0], Math.min(minWindow[1], s.length()));


    }
}
