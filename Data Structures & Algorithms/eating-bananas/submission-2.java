class Solution {
 public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Integer.MIN_VALUE, mid;
        int timeTaken, result = Integer.MAX_VALUE;

        for (int pile : piles) {
            low = Math.min(low, pile);
            high = Math.max(high, pile);
        }

        while (low <= high) {
            mid = low + ((high - low) / 2);
            timeTaken = timeTakenToFinishWithRate(mid, piles);

            if (timeTaken <= h) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }


        }

        return result == Integer.MAX_VALUE ? high : result;
    }

    private int timeTakenToFinishWithRate(int k, int[] piles) {
        int time = 0;
        for (int pile : piles) {
            time += (int) Math.ceil((double) pile / k);
        }
        return time;
    }
}
