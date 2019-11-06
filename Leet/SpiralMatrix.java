class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new ArrayList<Integer>();
        if(matrix.length == 1){
            List<Integer> spiral = new ArrayList<Integer>();
            for(int i=0;i<matrix[0].length;i++){
                spiral.add(matrix[0][i]);
            }
            // Collections.addAll(spiral, matrix[0]);
            return spiral;
        }
        
        return findSpiral(matrix);
    }
    
    private List<Integer> findSpiral(int[][] matrix){
        List<Integer> spiral = new ArrayList<>();
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;
        int startr=0, startc=0, endr=rows, endc=cols;
        
        while(startr<=endr && startc<=endc){
            goRight(matrix, startr, startc, endr, endc, spiral);
            startr++;
            goDown(matrix, startr, startc, endr, endc, spiral);
            endc--;
            goLeft(matrix, startr, startc, endr, endc, spiral);
            endr--;
            goUp(matrix, startr, startc, endr, endc,spiral);
            startc++;
            // System.out.println(startr+" "+endr+" "+startc+" "+endc);
        }
        
        return spiral;
    }
    
    private void goRight(int[][] matrix, int startr, int startc, int endr, int endc, List<Integer> spiral){
        if(startr>endr || startc>endc)
            return;
        for(int i=startc;i<=endc;i++)
            spiral.add(matrix[startr][i]);
    }

    private void goDown(int[][] matrix, int startr, int startc, int endr, int endc, List<Integer> spiral){
        if(startr>endr || startc>endc)
            return;
        for(int i=startr;i<=endr;i++)
            spiral.add(matrix[i][endc]);
    }

    private void goLeft(int[][] matrix, int startr, int startc, int endr, int endc, List<Integer> spiral){
        if(startr>endr || startc>endc)
            return;
        for(int i=endc;i>=startc;i--)
            spiral.add(matrix[endr][i]);
    }
    
    private void goUp(int[][] matrix, int startr, int startc, int endr, int endc, List<Integer> spiral){
        if(startr>endr || startc>endc)
            return;
        for(int i=endr;i>=startr;i--)
            spiral.add(matrix[i][startc]);
    }
}