class Solution {
    public int findGCD(int[] nums) {
        int large = 0;
        int small = 1001;
        for (int num : nums){
            large = Math.max(num, large);
            small = Math.min(num, small);
        }

        while (large != 0) {
            int temp = large;
            large = small % large;
            small = temp;
        }
        return small;
    }
}