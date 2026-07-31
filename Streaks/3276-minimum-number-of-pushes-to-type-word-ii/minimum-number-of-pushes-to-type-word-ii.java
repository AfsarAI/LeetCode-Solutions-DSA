class Solution {
    public int minimumPushes(String word) {
        int n = word.length();

        int[] freq = new int[26];
        for ( int i = 0; i < n; i++){
            freq[word.charAt(i) - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        int p = 1;
        int used = 0;
        for (int i = 25; i >= 0 && freq[i] > 0; i--) {
            ans += freq[i] * p;
            used++;
            if (used % 8 == 0) {
                p++;
            }
        }
        return ans;
    }
}