class Solution {
    public int characterReplacement(String s, int k) {
          HashMap<Character, Integer> characterFrequency = new HashMap<>();
//        Instead of tracking maxChar track maxFrequency, we dont need to update the var incase it goes down as that will
//        always result in a smaller valid window, only when maxfrquency goes up do we track it
        int maxFreq = 1;
        characterFrequency.put(s.charAt(0), 1);


        int l = 0, maxLength = 1;
        char currentChar;
        for (int r = 1; r < s.length(); r++) {
            currentChar = s.charAt(r);
            characterFrequency.merge(currentChar, 1, Integer::sum);

            if (characterFrequency.get(currentChar) > maxFreq) {
                maxFreq = characterFrequency.get(currentChar);
            }

            if (((r - l + 1) - maxFreq > k)) {
                while ((r - l + 1) - maxFreq > k) {
                    characterFrequency.put(s.charAt(l), characterFrequency.get(s.charAt(l)) - 1);
                    l++;
                }
            }

            maxLength = Math.max((r - l + 1), maxLength);

        }

        return maxLength;
    }
}
