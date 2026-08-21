class Solution {
    public int matchPlayersAndTrainers(int[] p, int[] t) {
        Arrays.sort(p);
        Arrays.sort(t);
        int ans = 0;
        int cnt = 0;
        while (ans < p.length && cnt < t.length) {
            if (t[cnt] >= p[ans]) {
                ans++;
            }
            cnt++;
        }
        return ans;
    }
}