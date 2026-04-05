public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for (char t : tasks) {
            count[t - 'A']++;
        }

        int maxf = 0;
        for (int c : count) {
            maxf = Math.max(maxf, c);
        }

        int maxCount = 0;
        for (int c : count) {
            if (c == maxf) maxCount++;
        }

        int time = (maxf - 1) * (n + 1) + maxCount;

        return Math.max(tasks.length, time);
    }
}