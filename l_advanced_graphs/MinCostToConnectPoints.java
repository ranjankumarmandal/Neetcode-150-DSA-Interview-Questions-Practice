public class MinCostToConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        boolean[] visit = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int res = 0, node = 0;

        for (int i = 0; i < n; i++) {
            visit[node] = true;
            int next = -1;

            for (int j = 0; j < n; j++) {
                if (visit[j]) continue;

                int d = Math.abs(points[node][0] - points[j][0]) +
                        Math.abs(points[node][1] - points[j][1]);

                if (d < dist[j]) dist[j] = d;

                if (next == -1 || dist[j] < dist[next]) next = j;
            }

            if (next != -1) {
                res += dist[next];
                node = next;
            }
        }

        return res;
    }
}