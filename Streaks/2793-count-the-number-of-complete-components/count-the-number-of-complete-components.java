class Solution {
    int nodes;
    int edges;
    public int countCompleteComponents(int n, int[][] edgesArr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edgesArr) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                nodes = 0;
                edges = 0;
                dfs(i, adj, visited);
                edges /= 2;
                if (edges == nodes * (nodes - 1) / 2)
                    answer++;
            }
        }
        return answer;
    }
    private void dfs(int node,
                     ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited) {
        visited[node] = true;
        nodes++;
        edges += adj.get(node).size();
        for (int next : adj.get(node)) {
            if (!visited[next])
                dfs(next, adj, visited);
        }
    }
}