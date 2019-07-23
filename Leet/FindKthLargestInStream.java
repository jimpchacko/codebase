class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue(k);
        initPriorityQueue(nums);
    }
    
    private void initPriorityQueue(int[] array){
        for(Integer i:array){
            if(pq.size()<k)
                pq.add(i);
            else{
                if(pq.peek() < i){
                    pq.poll();
                    pq.add(i);
                }
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() < k){
            pq.add(val);
            return pq.peek();
        } 
        if(val > pq.peek()){
            pq.poll();
            pq.add(val);
            return pq.peek();
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */



