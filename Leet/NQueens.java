class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n==0 || n==2 || n==3){
            return new ArrayList<List<String>>();
        }
        if(n==1){
            List<String> sub = new ArrayList<>();
            sub.add("Q");
            result.add(sub);
            return result;
        }

        String[][] board = new String[n][n];
        List<List<String>> positions = placeQueens(board, n);
        return positions;
    }

        private List<List<String>> placeQueens(String[][] board, int n){
        int r=0, c=0;
        resetBoard(board, n);
        List<List<String>> allResult = new ArrayList<>();

        while(r<n){
            int lastColumn = placeQueen(board, r, n);
            if(lastColumn != -1) {
//                printBoard(board);
                r++;
                if(r==n){
                    List<String> result = new ArrayList<>();
                    fillResult(result, board, n);
                    allResult.add(result);
                    r--;
                }
            } else{
                if(r>0)
                    r--;
                else
                    return allResult;
            }
        }
//        System.out.println(allResult);
        return allResult;
    }

    private void fillResult(List<String> result, String[][] board, int n){
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++)
                sb.append(board[i][j]);
            result.add(sb.toString());
        }
    }

    private int placeQueen(String[][] board, int row, int n){
        int c = 0;
        for(int i=0;i<n;i++){
            if(board[row][i] == "Q"){
                board[row][i] = ".";
                c = i+1;
                break;
            }
        }
        if(c==n){
            return -1;
        }
//        c= (c==0)?0:c+1;
        while(c<n){
            if(isGood(board, row, c, n)){
                board[row][c] = "Q";
                return c;
            } else {
                c++;
            }
        }

        return -1;
    }

    private boolean isGood(String[][] board, int row, int col, int n){
//        System.out.println("isFree at "+row+":"+col+" "+isFree(board[row][col])+"\n ## " + noConflict(board, row, col, n));
        return (isFree(board[row][col]) && noConflict(board, row, col, n));
    }

    private boolean isFree(String content){
        return (content == "" || content == null || content == ".");
    }

    private boolean noConflict(String[][] board, int row, int col, int n){
//        System.out.println("%%NO CONFLICT "+isRowClear(board, row, col, n) +" "+ isColClear(board, row, col, n) +" "+ areDiagonalsClear(board, row, col, n));
        return isRowClear(board, row, col, n) && isColClear(board, row, col, n) && areDiagonalsClear(board, row, col, n);
    }

    private boolean isRowClear(String[][] board, int row, int col, int n){
        boolean clean = true;
        for(int i=0;i<n;i++){
            if(board[row][i] == "Q") {
                clean = false;
                return clean;
            }
        }
        return clean;
    }

    private boolean isColClear(String[][] board, int row, int col, int n){
        boolean clean = true;
        for(int i=0;i<n;i++){
            if(board[i][col] == "Q") {
                clean = false;
                return clean;
            }
        }
        return clean;
    }

    private boolean areDiagonalsClear(String[][] board, int row, int col, int n){
        boolean clean = true;
        for(int i=col+1,j=row+1;i<n && j<n;i++,j++){
            if(board[j][i] == "Q") {
                clean = false;
                return clean;
            }
        }
        for(int i=col+1,j=row-1;i<n && j>-1;i++,j--){
            if(board[j][i] == "Q") {
                clean = false;
                return clean;
            }
        }

        for(int i=col-1,j=row+1;i>-1 && j<n;i--,j++){
            if(board[j][i] == "Q") {
                clean = false;
                return clean;
            }
        }

        for(int i=col-1,j=row-1;i>-1 && j>-1;i--,j--){
            if(board[j][i] == "Q") {
                clean = false;
                return clean;
            }
        }
        return clean;
    }

    private void resetBoard(String[][] board, int n){
        for(int i=0;i<n;i++){
            Arrays.fill(board[i], ".");
        }
    }

    private void resetBoardButOne(String[][] board, int n){
        for(int i=1;i<n;i++){
            Arrays.fill(board[i], ".");
        }
    }

    private void markInvalidCells(String[][] board,int row, int col, int n){
        markRow(board, row, col, n);
        markCol(board, row, col, n);
        markDiagonals(board, row, col, n);
    }

    private void markRow(String[][] board,int row, int col, int n){
        for(int i=0;i<n;i++){
            if(i!=col)
                board[row][i] = "X";
        }
    }

    private void markDiagonals(String[][] board, int row, int col, int n){
        for(int i=col+1,j=row+1;i<n && j<n;i++,j++){
            board[j][i] = "X";
        }
        for(int i=col+1,j=row-1;i<n && j>-1;i++,j--){
            board[j][i] = "X";
        }

        for(int i=col-1,j=row+1;i>-1 && j<n;i--,j++){
            board[j][i] = "X";
        }

        for(int i=col-1,j=row-1;i>-1 && j>-1;i--,j--){
            board[j][i] = "X";
        }
    }

    private void markCol(String[][] board,int row, int col, int n){
        for(int i=0;i<n;i++){
            if(i!=row)
                board[i][col] = "X";
        }
    }
}