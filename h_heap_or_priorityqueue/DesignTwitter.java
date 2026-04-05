public class DesignTwitter {
    private static int time = 0;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for (int followee : followMap.get(userId)) {
            List<int[]> tweets = tweetMap.getOrDefault(followee, new ArrayList<>());
            for (int i = tweets.size() - 1; i >= Math.max(0, tweets.size() - 10); i--) {
                maxHeap.offer(tweets.get(i));
            }
        }

        List<Integer> res = new ArrayList<>();
        int count = 0;

        while (!maxHeap.isEmpty() && count < 10) {
            res.add(maxHeap.poll()[1]);
            count++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        if (followerId != followeeId) {
            followMap.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}