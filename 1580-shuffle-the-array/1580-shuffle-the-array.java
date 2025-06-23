class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i = 0;
        int j = i + n;
        int k = 0;
        int ans[] = new int[nums.length];
        
        while(j < nums.length){
            ans[k++] = nums[i];
            ans[k++] = nums[j];
            i++;
            j++;
        }
        return ans;
    }
}