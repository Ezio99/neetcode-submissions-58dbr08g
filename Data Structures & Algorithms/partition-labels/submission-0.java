class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> characterCounts = new HashMap<>();

        char ch;
        for (int i = 0; i < s.length(); i++) {
            characterCounts.merge(s.charAt(i), 1, Integer::sum);
        }

        List<Integer> result = new ArrayList<>();
        Set<Character> characterSet = new HashSet<>();
        int wctr;
        for (int i = 0; i < s.length(); i++) {
            int charCtr = characterCounts.get(s.charAt(i));
            if (charCtr == 1) {
                result.add(1);
            } else {
                characterSet.add(s.charAt(i));
                wctr = 0;
                while (charCtr > 0) {
                    if (characterSet.contains(s.charAt(i))) {
                        charCtr--;
                    } else {
                        charCtr += characterCounts.get(s.charAt(i)) - 1;
                        characterSet.add(s.charAt(i));
                    }
                    i++;
                    wctr++;
                }
                result.add(wctr);
                i--;
            }
        }

        return result;
    }
}
