class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        Set<Integer> pairXors = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairXors.add(nums[i] ^ nums[j]);
            }
        }
        BitSet uniqueTriplets = new BitSet();
        for (int pair : pairXors) {
            for (int num : nums) {
                uniqueTriplets.set(pair ^ num);
            }
        }
        return uniqueTriplets.cardinality();
    }
}