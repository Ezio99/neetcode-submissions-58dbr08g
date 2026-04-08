class Solution {
 public void rotate(int[][] matrix) {
        if (matrix.length == 1) {
            return;
        }

        int ctr = 0, layerNumber = 0, n = matrix.length;
        int[] topLeft;
        int[] topRight;
        int[] bottomLeft;
        int[] bottomRight;
//        int[] right = new int[]{0, 1}, left = new int[]{0, -1}, up = new int[]{-1, 0}, down = new int[]{1, 0};
        int tmp;
        while (ctr < (n * n) - 1) {
            topLeft = new int[]{layerNumber, layerNumber};
            topRight = new int[]{layerNumber, n - 1 - layerNumber};
            bottomLeft = new int[]{n - 1 - layerNumber, layerNumber};
            bottomRight = new int[]{n - 1 - layerNumber, n - 1 - layerNumber};
            while (topLeft[1] < n - 1 - layerNumber) {
                tmp = matrix[topRight[0]][topRight[1]];
                matrix[topRight[0]][topRight[1]] = matrix[topLeft[0]][topLeft[1]];
                matrix[topLeft[0]][topLeft[1]] = matrix[bottomLeft[0]][bottomLeft[1]];
                matrix[bottomLeft[0]][bottomLeft[1]] = matrix[bottomRight[0]][bottomRight[1]];
                matrix[bottomRight[0]][bottomRight[1]] = tmp;
                topLeft[1] += 1;
                topRight[0] += 1;
                bottomRight[1] -= 1;
                bottomLeft[0] -= 1;
                ctr += 4;
            }

            layerNumber++;
        }

    }
}
