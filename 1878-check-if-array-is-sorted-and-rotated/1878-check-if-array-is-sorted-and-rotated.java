class Solution {
    public boolean check(int[] nums) {
        
        int curr = nums[0];
        int count = 0;

        for(int i = 1 ; i < nums.length ; i++){

            if( nums[i] > curr)
                curr = nums[i];
            
            else if(curr > nums[i]){
                count += 1;
                curr = nums[i];
            }
        }

        if(count == 0)
            return true;

        if(count == 1)
            return nums[0] >= nums[nums.length - 1];

        return false;
    }
}