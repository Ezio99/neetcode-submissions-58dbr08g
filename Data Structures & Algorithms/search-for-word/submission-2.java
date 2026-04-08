class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length, c = board[0].length;
        boolean[][] visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, visit, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(int i, int j, char[][] board, boolean[][] visit, String word, int ctr) {
                if (ctr == word.length()) {
            return true;
        }
        if (i < 0 || i >= visit.length || j < 0 || j >= visit[0].length) {
            return false;
        }
        if (visit[i][j]) {
            return false;
        }

        visit[i][j] = true;
        char ch = word.charAt(ctr);
        boolean found = false;
        if (ch == board[i][j]) {
            found = dfs(i + 1, j, board, visit, word, ctr + 1) || dfs(i - 1, j, board, visit, word, ctr + 1)
                    || dfs(i, j + 1, board, visit, word, ctr + 1) || dfs(i, j - 1, board, visit, word, ctr + 1);
        }

        visit[i][j] = false;
        return found;
    }
}
