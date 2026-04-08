class Solution {
  public boolean exist(char[][] board, String word) {
        int r = board.length, c = board[0].length;
        boolean[][] visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (inplacedfs(i, j, board, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean inplacedfs(int i, int j, char[][] board, String word, int ctr) {
        if (ctr == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }


        char ch = word.charAt(ctr);
        boolean found = false;
        if (ch == board[i][j]) {
            board[i][j] = '#';
            found = inplacedfs(i + 1, j, board, word, ctr + 1) || inplacedfs(i - 1, j, board, word, ctr + 1)
                    || inplacedfs(i, j + 1, board, word, ctr + 1) || inplacedfs(i, j - 1, board, word, ctr + 1);
            board[i][j] = ch;
        }


        return found;
    }
}
