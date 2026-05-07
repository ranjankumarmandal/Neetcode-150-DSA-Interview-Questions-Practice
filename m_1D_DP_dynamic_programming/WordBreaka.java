public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (String word : set) {
                int len = word.length();
                if (i + len <= n && s.startsWith(word, i) && dp[i + len]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}