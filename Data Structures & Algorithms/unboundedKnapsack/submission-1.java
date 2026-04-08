class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        return bottomUp(profit,weight,capacity);
    }

    private int bottomUp(List<Integer> profit, List<Integer> weight, int capacity) {
        //Initially all 0 to act as a dummy where the previous best value is 0
        //+1 because we need to have the index of actual capacity instead of capacity-1
        int[] prevRow = new int[capacity+1];


        int skipVal = 0, includeVal = 0;
        for (int i = 0; i < profit.size(); i++) {
            int[] newRow = new int[capacity+1];
            //At capacity 0 profit will be 0 since no item has weight 0 to fit in a cap 0 bag
            //So we start j from 1
            for (int j = 1; j < capacity+1; j++) {
                skipVal = prevRow[j];
                includeVal = 0;
                if (j - weight.get(i) >= 0) {
                    //Don't use prev row here because we want the best profit inclusive of the option of including this item
                    // multiple times
                    includeVal = profit.get(i) + newRow[j - weight.get(i)];
                }
                newRow[j] = Math.max(skipVal,includeVal);
            }
            prevRow = newRow;
        }

        return prevRow[prevRow.length-1];
    }
}
