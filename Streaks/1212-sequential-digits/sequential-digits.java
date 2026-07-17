class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int len = 2; len <= 9; len++) {
            for (int start = 1; start <= 10 - len; start++) {
                int num = 0;
                for (int digit = start; digit < start + len; digit++) {
                    num = num * 10 + digit;
                }
                if (num >= low && num <= high)
                    ans.add(num);
            }
        }
        return ans;
    }
}