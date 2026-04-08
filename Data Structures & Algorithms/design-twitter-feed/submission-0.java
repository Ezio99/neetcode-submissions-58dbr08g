class Twitter {

    Map<Integer, Set<Integer>> userFollows;

    //UserId, TweetId, Time
    PriorityQueue<int[]> posts;
    int time;

    public Twitter() {
        posts = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[2], o1[2]);
            }
        });

        userFollows = new HashMap<>();

        time = 0;

    }

    public void postTweet(int userId, int tweetId) {
        posts.offer(new int[]{userId, tweetId, time++});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> copyPosts = new PriorityQueue<>(posts);

        List<Integer> result = new ArrayList<>();
        while (result.size() < 10 && !copyPosts.isEmpty()) {
            int[] post = copyPosts.poll();

            if (post[0] == userId || userFollows.getOrDefault(userId, new HashSet<>()).contains(post[0])) {
                result.add(post[1]);
            }
        }

        return result;
    }

    //A follows B
    public void follow(int followerId, int followeeId) {
        userFollows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userFollows.containsKey(followerId)) {
            userFollows.get(followerId).remove(followeeId);
        }
    }
}
