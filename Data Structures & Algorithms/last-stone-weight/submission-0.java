class Solution {
  public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int stone: stones){
            pq.offer(stone);
        }

        int s1,s2,res;
        while(pq.size()>1){
            s1 = pq.poll();
            s2 = pq.poll();
            res = Math.abs(s1-s2);
            if(res>0){
                pq.offer(res); 
            }
        }
        
        if(pq.isEmpty()){
            return 0;
        }
        
        return pq.poll();


    }
}
