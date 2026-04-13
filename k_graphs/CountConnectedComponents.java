public class CountConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        int components = n;

        for (int[] e : edges) {
            if (union(e[0], e[1], parent, rank)) {
                components--;
            }
        }

        return components;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) parent[x] = find(parent[x], parent);
        return parent[x];
    }
}