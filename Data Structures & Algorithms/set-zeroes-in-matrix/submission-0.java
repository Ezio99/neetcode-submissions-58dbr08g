class Solution {
    public void setZeroes(int[][] matrix) {
        int[][] zeroLoc = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroLoc[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroLoc[i][j]==1) {
                    setRowAndColZero(i,j,matrix);
                }
            }
        }
        
    }

    public void setRowAndColZero(int r, int c, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][c] = 0;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            matrix[r][i] = 0;
        }
    }
}
