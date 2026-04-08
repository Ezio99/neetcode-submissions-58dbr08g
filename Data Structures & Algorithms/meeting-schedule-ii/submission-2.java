/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        int ctr = 0, count = 0;
        for (Interval interval : intervals) {
            start[ctr] = interval.start;
            end[ctr] = interval.end;
            ctr++;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int minRooms = Integer.MIN_VALUE;
        int startIndex = 0, endIndex = 0;
        while (startIndex < n) {
            if (start[startIndex] < end[endIndex]) {
                count++;
                startIndex++;
            } else {
                count--;
                endIndex++;
            }

            if (count > minRooms) {
                minRooms = count;
            }
        }

        return minRooms;
    }
}
