class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pointQ = new PriorityQueue<int[]>(new Comparator<int[]>(){
            
            @Override
            public int compare(int[] t1, int[] t2){
                return (int)findDistance(t2) - (int)findDistance(t1);
            }
        });
        
        for(int i=0;i<points.length;i++){
            if(pointQ.size() < K){
                pointQ.add(points[i]);
            } else{
                pointQ.add(points[i]);
                pointQ.poll();
            }
        }
        
        int[][] kClosest = new int[K][2];
        int i = 0;
        while(!pointQ.isEmpty()){
            kClosest[i] = pointQ.poll();
            i++;
        }
        return kClosest;
    }
    
    private double findDistance(int[] xy){
        
        double sum = Math.pow(xy[0], 2) + Math.pow(xy[1], 2);
        return sum;
    }
}
