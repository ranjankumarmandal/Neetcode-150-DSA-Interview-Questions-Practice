public class CountConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];


        for (int[] e : edges) {
            if (union(e[0], e[1], parent, rank)) {
                components--;
            }
        }

        return components;
    }
}