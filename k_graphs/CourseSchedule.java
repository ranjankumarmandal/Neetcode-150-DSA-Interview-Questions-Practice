public class CourseSchedule {
    List<List<Integer>> graph;
    int[] state;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            graph.get(p[0]).add(p[1]);
        }

        state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }

        return true;
    }

    private boolean dfs(int node) {
        if (state[node] == 1) return false;
        if (state[node] == 2) return true;

        state[node] = 1;

        for (int nei : graph.get(node)) {
            if (!dfs(nei)) return false;
        }

        state[node] = 2;
        return true;
    }
}