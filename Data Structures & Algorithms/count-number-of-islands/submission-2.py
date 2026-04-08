class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        numIslands=0
        ROWS,COLS = len(grid),len(grid[0])
        
        for r in range(0,ROWS):
            for c in range(0,COLS):
                if grid[r][c]=='1':
                    numIslands+=1
                    self.dfs(grid,r,c)


        
        return numIslands


    def dfs(self,grid: List[List[str]],r:int,c:int):
        if r<0 or c<0 or r>= len(grid) or c>=len(grid[0]):
            return

        if grid[r][c]=='0' or grid[r][c]=='2':
            return
        if grid[r][c]=='1':
            grid[r][c]='2'
        
        self.dfs(grid,r+1,c)
        self.dfs(grid,r,c+1)
        self.dfs(grid,r-1,c)
        self.dfs(grid,r,c-1)

        
        
        