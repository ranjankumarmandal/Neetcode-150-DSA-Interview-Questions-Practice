public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int[] res = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            res[idx++] = node;

            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) q.offer(nei);
            }
        }

        return idx == numCourses ? res : new int[0];
    }
}