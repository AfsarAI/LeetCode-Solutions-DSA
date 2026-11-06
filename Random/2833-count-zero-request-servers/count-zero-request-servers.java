class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length;
        int q = queries.length;
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        Integer[] indices = new Integer[q];
        for (int i = 0; i < q; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) ->
            Integer.compare(queries[a], queries[b])
        );
        int[] freq = new int[n + 1];
        int activeServers = 0;
        int left = 0;
        int right = 0;
        int[] ans = new int[q];
        for (int idx : indices) {
            int time = queries[idx];
            while (right < m && logs[right][1] <= time) {
                int serverId = logs[right][0];
                if (freq[serverId] == 0) {
                    activeServers++;
                }
                freq[serverId]++;
                right++;
            }
            while (left < right && logs[left][1] < time - x) {
                int serverId = logs[left][0];
                freq[serverId]--;
                if (freq[serverId] == 0) {
                    activeServers--;
                }
                left++;
            }
            ans[idx] = n - activeServers;
        }
        return ans;
    }
}
