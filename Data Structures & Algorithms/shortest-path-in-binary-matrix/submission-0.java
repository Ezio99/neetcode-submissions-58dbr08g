class Solution {
   public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if (grid[0][0] == 1) return -1;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{
                {1, 1},
                {1, -1},
                {-1, 1},
                {-1, -1},
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1},
        };

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int length = 1;
        while (!queue.isEmpty()) {
            //Iterate for current nodes and add their neighbours
            int currentQueueSize = queue.size();
            for (int i = 0; i < currentQueueSize; i++) {
                int[] coordinate = queue.poll();
                if (coordinate[0] == (rows - 1) && coordinate[1] == cols - 1) return length;

                for (int[] direction : directions) {
                    int[] neighbour = new int[]{coordinate[0] + direction[0], coordinate[1] + direction[1]};
                    if (neighbour[0] < rows && neighbour[0] >= 0 &&
                            neighbour[1] < cols && neighbour[1] >= 0 &&
                            grid[neighbour[0]][neighbour[1]] != 1 &&
                            !visited[neighbour[0]][neighbour[1]]) {
                        queue.offer(neighbour);
                        //Add visited preemptively so we dont add the same point again
                        visited[neighbour[0]][neighbour[1]] = true;
                    }
                }

            }
            length++;
        }

        return -1;
    }
}