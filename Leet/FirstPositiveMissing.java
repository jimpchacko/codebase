class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        
        for(int i=0;i<length;i++){
            if(nums[i]<=0 || nums[i]>length)
                nums[i] = length+1;
        }
        
        for(int i=0;i<length;i++){
                int abs = Math.abs(nums[i]);
                if(abs > length)
                    continue;
                abs--;
                if(nums[abs] > 0)
                    nums[abs] = -nums[abs];
        }
        
        for(int i=0;i<length;i++){
            if(nums[i] > 0)
                return i+1;
        }
        return length+1;
    }
}
