class Solution {
  public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double distA = Math.sqrt(Math.pow(o1[0], 2) + Math.pow(o1[1], 2));
                double distB = Math.sqrt(Math.pow(o2[0], 2) + Math.pow(o2[1], 2));

                if (distA - distB > 0) return -1;
                else if (distA - distB == 0) return 0;

                return 1;
            }
        });

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] results = new int[maxHeap.size()][2];
        int ctr = 0;
        while (!maxHeap.isEmpty()) {
            results[ctr++] = maxHeap.poll();
        }
        
        return results;
    }
}
