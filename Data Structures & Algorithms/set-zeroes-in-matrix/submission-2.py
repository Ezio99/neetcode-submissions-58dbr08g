class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        rowSet = set()
        colSet=set()

        for i in range(0,len(matrix)):
            for j in range(0,len(matrix[i])):
                if matrix[i][j]==0:
                    rowSet.add(i)
                    colSet.add(j)
        
        for i in range(0,len(matrix)):
            for j in range(0,len(matrix[i])):
                if i in rowSet or j in colSet:
                    matrix[i][j]=0
        
        
        
        