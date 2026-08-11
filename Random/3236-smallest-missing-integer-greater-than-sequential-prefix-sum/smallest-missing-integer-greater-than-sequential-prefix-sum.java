class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

        // Find longest sequential prefix sum
        int sum = nums[0];

        int i = 1;
        while (i < n && nums[i] == nums[i - 1] + 1) {
            sum += nums[i];
            i++;
        }

        // Put all numbers in set
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        // Find smallest missing >= sum
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}