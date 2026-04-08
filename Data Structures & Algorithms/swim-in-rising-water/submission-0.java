class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(grid[o1[0]][o1[1]], grid[o2[0]][o2[1]]);
            }
        });
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[]{0, 0});
        int[][] directions = new int[][]{
                {0, 1},
                {1, 0},
                {-1, 0},
                {0, -1}
        };
        int maxNum = grid[0][0];
        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            int x = coord[0], y = coord[1];


            maxNum = Math.max(maxNum, grid[x][y]);

            if (x == n - 1 && y == n - 1) break;

            for (int[] direction : directions) {
                int x1 = x + direction[0], y1 = y + direction[1];
                if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n && !visited[x1][y1]) {
                    queue.offer(new int[]{x1, y1});
                    visited[x1][y1] = true;
                }
            }
        }

        return maxNum;
    }
}