class Twitter {

  Map<Integer, Set<Integer>> userFollows;
    // TweetId,Time
    Map<Integer, Set<int[]>> posts;

    //UserId, TweetId, Time

    int time;

    public Twitter() {
        posts = new HashMap<>();

        userFollows = new HashMap<>();

        time = 0;

    }

    public void postTweet(int userId, int tweetId) {
        posts.computeIfAbsent(userId, k -> new HashSet<>()).add(new int[]{tweetId, time++});
    }

    public List<Integer> getNewsFeed(int userId) {
        //TweetId,Time
        PriorityQueue<int[]> orderedPosts = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        for (Integer currUser : posts.keySet()) {
            if (currUser == userId || userFollows.getOrDefault(userId, new HashSet<>()).contains(currUser)) {
                orderedPosts.addAll(new ArrayList<>(posts.get(currUser)));
            }
        }
        System.out.println(orderedPosts.peek());

        List<Integer> result = new ArrayList<>();
        while (result.size() < 10 && !orderedPosts.isEmpty()) {
                result.add(orderedPosts.poll()[0]);
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
