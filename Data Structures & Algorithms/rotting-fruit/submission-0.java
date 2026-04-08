class Solution {
    int numRotten,numFresh;
    public int orangesRotting(int[][] grid) {
        numRotten=0;
        numFresh=0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    numFresh++;
                }
                else if(grid[i][j]==2){
                    numRotten++;
                    queue.add(new int[]{i,j});
                }
            }
        }

        if(numRotten==0 && numFresh>0){
            return -1;
        }
        if(numFresh==0){
            return 0;
        }

        int ctr=0;
        Queue<int[]> latestQueue;
        while(numFresh>0){
            int currFresh=numFresh;
             latestQueue= new LinkedList<>();
             while(!queue.isEmpty()){
                int[] pos = queue.poll();
                int i =pos[0],j=pos[1];
                if(i-1>=0){
                    checkAndChangeToRotten(grid, i-1, j, latestQueue);
                }
                if(j-1>=0){
                    checkAndChangeToRotten(grid, i, j-1, latestQueue);
                }
                if(i+1<grid.length){
                    checkAndChangeToRotten(grid, i+1, j, latestQueue);
                }
                if(j+1<grid[0].length){
                    checkAndChangeToRotten(grid, i, j+1, latestQueue);
                }
             }
             //No change
             if(currFresh==numFresh){
                return -1;
             }
             ctr++;
             queue=latestQueue;

        }

        return ctr;


    }

    public boolean checkAndChangeToRotten(int[][] grid,int i,int j,Queue<int[]> latestQueue){
        if(grid[i][j]==1){
            grid[i][j]=2;
            latestQueue.add(new int[]{i,j});
            numFresh--;
            return true;
        }
        return false;
    }


}