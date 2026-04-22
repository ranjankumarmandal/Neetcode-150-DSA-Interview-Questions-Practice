public class SwimInRaisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], r = curr[1], c = curr[2];

            if (r == n - 1 && c == n - 1) return time;
            if (visited[r][c]) continue;

            visited[r][c] = true;

            for (int[] d : dir) {
                int nr = r + d[0], nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                    pq.offer(new int[]{Math.max(time, grid[nr][nc]), nr, nc});
                }
            }
        }

        return -1;
    }
}