class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[n-1];
        int i = 0;
        for(int j = min; j <= max; j++){
            if(nums[i] != j){
                ans.add(j);
            }else{
                i++;
            }
        }
        return ans;
    }
}