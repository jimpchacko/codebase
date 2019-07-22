class Solution {
    public int findMaxLength(int[] nums) {
        
        Map<Integer, List<Integer>> counts = new HashMap<>();
        int sum = 0, maxDiff = 0;
        ArrayList<Integer> zeroth = new ArrayList<>();
        zeroth.add(-1);
        counts.put(sum, zeroth);
        
        for(int i=0;i<nums.length;i++){
            sum += (nums[i] == 1)?1:-1;
            if(!counts.containsKey(sum))
                counts.put(sum, new ArrayList<Integer>());
            List<Integer> subList = (ArrayList)counts.get(sum);
            if(subList.size()<2){
                subList.add(i);
                if(subList.size()==2){
                    maxDiff = Math.max(maxDiff, subList.get(1) - subList.get(0));
                }
            } else{
                subList.remove(1);
                subList.add(i);
                int currDiff = subList.get(1) - subList.get(0);
                maxDiff = Math.max(currDiff, maxDiff);
            }
        }
        
        return maxDiff;
    }
}
