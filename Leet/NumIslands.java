class Solution {
    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        passWater(grid);
        int numClosedIslands = dfsOnGrid(grid);

        return numClosedIslands;
    }
    
    private int dfsOnGrid(int[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numIslands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!(visited[i][j]) && grid[i][j]==0){
                    dfs(grid, visited, i, j);
                    numIslands++;
                }
            }
        }
        
        return numIslands;
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int i, int j){
        if(!visited[i][j]){
            visited[i][j] = true;
            for(List<Integer> index:getNeighbours(grid, i, j)){
                dfs(grid, visited, index.get(0), index.get(1));
            }
        }
    }
    
    private void passWater(int[][] grid){
        for(int i=0;i<grid.length;i++){
            markUsingDFS(grid, i, 0);
            markUsingDFS(grid, i, grid[0].length-1);
        }
        
        for(int i=0;i<grid[0].length;i++){
            markUsingDFS(grid, 0, i);
            markUsingDFS(grid, grid.length-1, i);
        }
    }
    
    private void markUsingDFS(int[][] grid, int i, int j ){
        if(grid[i][j] != 1){
            grid[i][j] = 1;
            for(List<Integer> index:getNeighbours(grid, i, j)){
                markUsingDFS(grid, index.get(0), index.get(1));
            }
        }
    }
    
    private List<List<Integer>> getNeighbours(int[][] grid, int r, int c){
        List<List<Integer>> neighbours = new ArrayList<>();
        if(r>0 && grid[r-1][c]==0){
            List<Integer> pair = new ArrayList<>();
            pair.add(r-1);
            pair.add(c);
            neighbours.add(pair);
        }
        if(r<grid.length-1 && grid[r+1][c]==0){
            List<Integer> pair = new ArrayList<>();
            pair.add(r+1);
            pair.add(c);
            neighbours.add(pair);
        }
        if(c<grid[0].length-1 && grid[r][c+1]==0){
            List<Integer> pair = new ArrayList<>();
            pair.add(r);
            pair.add(c+1);
            neighbours.add(pair);
        }
        if(c>0 && grid[r][c-1]==0){
            List<Integer> pair = new ArrayList<>();
            pair.add(r);
            pair.add(c-1);
            neighbours.add(pair);
        }
        
        return neighbours;
    }
}