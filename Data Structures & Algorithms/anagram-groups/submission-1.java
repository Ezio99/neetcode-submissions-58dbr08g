class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        char[] arr;
        String key;
        for (String s : strs) {
            arr = s.toCharArray();
            Arrays.sort(arr);
            key = Arrays.toString(arr);
            anagrams.computeIfAbsent(key, v -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(anagrams.values());
        
        
    }
}
