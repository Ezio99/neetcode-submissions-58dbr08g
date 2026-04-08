class Solution {
        public int minCostConnectPoints(int[][] points) {
        int[] point1, point2;
        int dist;
        HashMap<Integer, List<int[]>> adjacencyList = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            point1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                point2 = points[j];
                dist = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
                adjacencyList.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{j, dist});
                adjacencyList.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{i, dist});
            }
        }

        boolean[] visited = new boolean[points.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        pq.offer(new int[]{0, 0});
        int sum = 0, ctr = 0;

        while (!pq.isEmpty()) {
            int[] currentNode = pq.poll();

            if (visited[currentNode[0]]) {
                continue;
            }

            visited[currentNode[0]] = true;
            sum += currentNode[1];
            ctr++;

            if (ctr == points.length) {
                break;
            }
            List<int[]> neighbhourList = adjacencyList.get(currentNode[0]);
            for (int[] neighbour : neighbhourList) {
                if (!visited[neighbour[0]]) {
                    pq.add(neighbour);
                }
            }

        }

        return sum;
    }
}
