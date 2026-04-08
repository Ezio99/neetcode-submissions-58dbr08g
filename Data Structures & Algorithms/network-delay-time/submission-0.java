class Solution {
  public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjacencyMap = new HashMap<>();
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int[] edge : times) {
            adjacencyMap.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        //To, weight
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currentNode = curr[0], distToReachCurrentNode = curr[1];

            if (visited[currentNode]) continue;

            if (distToReachCurrentNode < dist[currentNode]) dist[currentNode] = distToReachCurrentNode;

            visited[currentNode] = true;


            List<int[]> neighbours = adjacencyMap.getOrDefault(currentNode, new ArrayList<>());

            for (int[] neighbour : neighbours) {
                if (!visited[neighbour[0]] && distToReachCurrentNode + neighbour[1] < dist[neighbour[0]]) {
                    pq.offer(new int[]{neighbour[0], distToReachCurrentNode + neighbour[1]});
                }
            }
        }

          int ans=Integer.MIN_VALUE;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans,dist[i]);
        }

        return ans;
    }
}