class Solution {
   public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minHeapByCapital = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        //Capital,Profit
        PriorityQueue<int[]> maxHeapByProfit = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));

        for (int i = 0; i < profits.length; i++) {
            minHeapByCapital.offer(new int[]{capital[i], profits[i]});
        }


        int projectsDone = 0;
        while (projectsDone < k) {
            while (!minHeapByCapital.isEmpty() && minHeapByCapital.peek()[0] <= w) {
                maxHeapByProfit.offer(minHeapByCapital.poll());
            }
            if(maxHeapByProfit.isEmpty()) break;
            int[] selectedProject = maxHeapByProfit.poll();
            w += selectedProject[1];
            projectsDone++;
        }

        return w;
    }
}