class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> counts = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(counts.containsKey(nums[i])){
                int count = counts.get(nums[i]);
                counts.put(nums[i], ++count);
            } else
                counts.put(nums[i], 1);
        }
        
        /*PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator(){
            
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2){
                return entry2.getValue() - entry1.getValue();
            }
        });*/
   
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> t1, Map.Entry<Integer, Integer> t2) {
                return t1.getValue() - t2.getValue();
            }
        });

        // System.out.println(counts);
        for(Map.Entry<Integer, Integer> entry:counts.entrySet()){
            if(pq.size()<k)
                pq.add(entry);
            else{
                if(pq.peek().getValue() < entry.getValue()){
                    pq.poll();
                    pq.add(entry);
                }
                // System.out.println(pq);
            }
        }
        
        List<Integer> freq = new ArrayList<Integer>();
        for(int i=0;i<k;i++){
            freq.add(pq.poll().getKey());
        }
        
        return freq;
    }
}
