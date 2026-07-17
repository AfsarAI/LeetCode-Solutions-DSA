class Solution {
    public int smallestAbsent(int[] nums) {
        int n = nums.length;
        long sum = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            sum += num;
            set.add(num);
        }

        int ans = (int) Math.floorDiv(sum, n) + 1;
        ans = Math.max(ans, 1);

        while (set.contains(ans)) {
            ans++;
        }

        return ans;
    }
}