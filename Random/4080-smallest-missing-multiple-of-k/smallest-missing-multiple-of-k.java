class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 1;
        while(Arrays.binarySearch(nums, k*i) >= 0){
            i++;
        }
        return k*i;
    }
}