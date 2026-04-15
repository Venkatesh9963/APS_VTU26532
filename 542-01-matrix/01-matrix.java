import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        // Step 1: add all 0s to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
                    dist[x][y] = dist[cur[0]][cur[1]] + 1;
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
        }

        return dist;
    }
}