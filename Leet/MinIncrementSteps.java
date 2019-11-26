class MinIncrementSteps {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        
        int count = 0;
        for(int i=0;i<A.length-1;i++){
            if(A[i] == A[i+1]){
                A[i+1] = A[i] + 1;
                count++;
            } else if(A[i] > A[i+1]){
                /*while(A[i] >= A[i+1]){
                    A[i+1] = A[i+1] + 1;
                    count++;
                }*/
                count += A[i] - A[i+1] + 1;
                A[i+1] = A[i] + 1;
            }
        }
        
        return count;
    }
}