You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

 

Example 1:


Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:


Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 500



  class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}


class Solution {
     public int numEnclaves(int[][] grid) {
        int n =grid.length;
        int m=grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int vis[][]=new int [n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // first low and col     last row and col
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        vis[i][j]=1;
                    }

                }
            }
        }

        int delRow[]={-1, 0, 1, 0};
        int delCol[]={0, 1, 0, -1};

        while(!q.isEmpty()){
            int row=q.peek().first;
            int col = q.peek().second;

            q.remove();

            for(int i=0;i<4;i++){
                int nRow = row+delRow[i];
                int nCol = col+delCol[i];

                if(nRow>=0 && nRow<n  && nCol>=0 && nCol<m && vis[nRow][nCol]==0 && grid[nRow][nCol]==1){
                        q.add(new Pair(nRow, nCol));
                        vis[nRow][nCol]=1;
                }
            }
        }

        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] ==1 & vis[i][j]==0)
                cnt++;
            }
        }

        return cnt;
    }
}
