class Solution {
    
    int rows, cols;
    public  int countPaths(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        return helperDFS(grid, 0, 0, new int[rows][cols]);
    }

    private  int helperDFS(int[][] grid, int x, int y, int[][] visited) {
        if (Math.min(x, y) < 0
                || x == rows
                || y == cols
                || visited[x][y] == 1
                || grid[x][y] == 1) {
            return 0;
        }
        if (x == rows - 1 && y == cols - 1) {
            return 1;
        }

        int ctr = 0;
        visited[x][y] = 1;
        ctr += helperDFS(grid, x + 1, y, visited);
        ctr += helperDFS(grid, x - 1, y, visited);
        ctr += helperDFS(grid, x, y + 1, visited);
        ctr += helperDFS(grid, x, y - 1, visited);
        visited[x][y] = 0;


        return ctr;

    }
}
