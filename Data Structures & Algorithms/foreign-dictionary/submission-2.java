class Solution {
  public String foreignDictionary(String[] words) {
        List<Character[]> edges = new ArrayList<>();
        HashMap<Character, List<Character>> adjacencyMap = new HashMap<>();
        HashMap<Character, Integer> inDegreeMap = new HashMap<>();

        for (String word : words) {
            int j;
            for (j = 0; j < word.length(); j++) {
                inDegreeMap.putIfAbsent(word.charAt(j), 0);
                adjacencyMap.putIfAbsent(word.charAt(j), new ArrayList<>());
            }
        }


        char ch1, ch2;
        int j;
        for (int i = 0; i < words.length - 1; i++) {
            for (j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                ch1 = words[i].charAt(j);
                ch2 = words[i + 1].charAt(j);
                if (ch1 != ch2) {
                    edges.add(new Character[]{words[i].charAt(j), words[i + 1].charAt(j)});
                    adjacencyMap.computeIfAbsent(ch1, k -> new ArrayList<>()).add(ch2);
                    inDegreeMap.merge(ch2, 1, Integer::sum);
                    break;
                }
            }
            // Invalid order
            if (j == Math.min(words[i].length(), words[i + 1].length()) &&
                    words[i].length() > words[i + 1].length()) {
                return "";
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (Character key : inDegreeMap.keySet()) {
            if (inDegreeMap.get(key) == 0) {
                queue.offer(key);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            Character ch = queue.poll();
            List<Character> neighbours = adjacencyMap.getOrDefault(ch, new ArrayList<>());

            for (Character neighbour : neighbours) {
                inDegreeMap.merge(neighbour, -1, Integer::sum);
                if (inDegreeMap.get(neighbour) == 0) queue.offer(neighbour);
            }

            result.append(ch);
        }

        for (Character key : inDegreeMap.keySet()) {
            if (inDegreeMap.get(key) != 0) {
                return "";
            }
        }

        return result.toString();

    }
}
