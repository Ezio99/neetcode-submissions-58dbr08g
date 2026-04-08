class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndexOfCharacter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndexOfCharacter[s.charAt(i) - 'a'] = i;
        }


        int end = 0;
        List<Integer> result = new ArrayList<>();
        int wctr = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndexOfCharacter[s.charAt(i) - 'a']);
            wctr++;

            if (i == end) {
                result.add(wctr);
                wctr = 0;
            }
        }

        return result;
    }
}
