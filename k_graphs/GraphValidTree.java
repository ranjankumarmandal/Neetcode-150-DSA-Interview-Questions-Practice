public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] e : edges) {
            if (!union(e[0], e[1], parent, rank)) return false;
        }

        return true;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) parent[x] = find(parent[x], parent);
        return parent[x];
    }
}