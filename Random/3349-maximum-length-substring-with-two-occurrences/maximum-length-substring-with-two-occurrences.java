class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int i = 0, j = 0, ans = 0;
        while (j < n) {
            freq[s.charAt(j) - 'a']++;
            while (freq[s.charAt(j) - 'a'] > 2) {
                freq[s.charAt(i) - 'a']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}