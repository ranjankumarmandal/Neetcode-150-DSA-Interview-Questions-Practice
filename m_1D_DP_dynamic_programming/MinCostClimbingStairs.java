public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i <= n; i++) {
            int fromOneStep = dp[i - 1] + cost[i - 1];
            int fromTwoStep = dp[i - 2] + cost[i - 2];

            dp[i] = Math.min(fromOneStep, fromTwoStep);
        }

        return dp[n];
    }
}