class Solution {

    void dfs(int u, ArrayList<Integer>[] adj, boolean[] vis) {
        vis[u] = true;
        for (int v : adj[u]) {
            if (!vis[v])
                dfs(v, adj, vis);
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] e : invocations)
            adj[e[0]].add(e[1]);

        boolean[] vis = new boolean[n];
        dfs(k, adj, vis);

        for (int[] e : invocations) {
            int u = e[0];
            int v = e[1];
            if (!vis[u] && vis[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    ans.add(i);
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (!vis[i])
                ans.add(i);
        return ans;
    }
}