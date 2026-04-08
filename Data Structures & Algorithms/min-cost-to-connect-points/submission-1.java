class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int cost = 0;

        //To index,Cost
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        //
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int currIndex = arr[0], currCost = arr[1];

            if (visited[currIndex]) continue;

            visited[currIndex] = true;

            cost += currCost;

            for (int i = 0; i < n; i++) {
                if (currIndex == i) continue;
                if (!visited[i]) {
                    pq.offer(new int[]{i, getCost(points[currIndex], points[i])});
                }
            }

        }

        return cost;


    }

    private int getCost(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
