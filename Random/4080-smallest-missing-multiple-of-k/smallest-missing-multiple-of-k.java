class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int m = k;
        while (numSet.contains(m)) {
            m += k;
        }
        return m;
    }
}