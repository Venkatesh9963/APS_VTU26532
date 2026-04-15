import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        List<List<Integer>> red = new ArrayList<>();
        List<List<Integer>> blue = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            red.add(new ArrayList<>());
            blue.add(new ArrayList<>());
        }

        for (int[] e : redEdges) red.get(e[0]).add(e[1]);
        for (int[] e : blueEdges) blue.get(e[0]).add(e[1]);

        int[][] dist = new int[n][2];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        // start from node 0 with both possibilities
        q.add(new int[]{0, 0}); // last red
        q.add(new int[]{0, 1}); // last blue

        dist[0][0] = 0;
        dist[0][1] = 0;

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int node = cur[0];
                int color = cur[1];

                List<Integer> nextNodes = (color == 1) ? red.get(node) : blue.get(node);

                for (int nei : nextNodes) {
                    if (dist[nei][1 - color] == Integer.MAX_VALUE) {
                        dist[nei][1 - color] = level + 1;
                        q.add(new int[]{nei, 1 - color});
                    }
                }
            }

            level++;
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int min = Math.min(dist[i][0], dist[i][1]);
            ans[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }

        return ans;
    }
}