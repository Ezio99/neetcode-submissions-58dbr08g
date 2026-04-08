class Solution {
    public int maxArea(int[] heights) {
        int maxAreaFound = 0, l = 0, r = heights.length - 1;
        int currArea;
        while (r > l) {
            currArea = (r - l) * (Math.min(heights[r], heights[l]));
            maxAreaFound = Math.max(maxAreaFound, currArea);

            if (heights[r] > heights[l]) {
                l++;
            } else {
                r--;
            }
        }

        return maxAreaFound;
    }
}
