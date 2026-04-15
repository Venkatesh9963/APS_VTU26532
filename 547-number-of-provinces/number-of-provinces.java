class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited, n);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, int[][] graph, boolean[] visited, int n) {
        visited[node] = true;

        for (int j = 0; j < n; j++) {
            if (graph[node][j] == 1 && !visited[j]) {
                dfs(j, graph, visited, n);
            }
        }
    }
}