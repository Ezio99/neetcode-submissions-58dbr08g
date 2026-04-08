class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> netInterval = new ArrayList<>();
        netInterval.add(intervals[0]);


        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < netInterval.get(netInterval.size() - 1)[1]) {
                if (netInterval.get(netInterval.size() - 1)[1] > intervals[i][1]) {
                    netInterval.set(netInterval.size() - 1, intervals[i]);
                }
                continue;
            }
            netInterval.add(intervals[i]);
        }

        return intervals.length - netInterval.size();
    }
}
