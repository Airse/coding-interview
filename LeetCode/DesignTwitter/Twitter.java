class Twitter {
  HashMap<Integer, User> userMap;

  public Twitter() {
    userMap = new HashMap<Integer, User>();
  }
  
  private User getUser(int userId) {
  User user = userMap.get(userId);
    if (user == null) {
      user = new User(userId);
      userMap.put(userId, user);
    }

    return user;
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    User user = getUser(userId);
    user.tweet(tweetId);
  }
  
  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {
    PriorityQueue<Tweet> tweets = new PriorityQueue<Tweet>();
    List<Integer> result = new ArrayList<Integer>();
    User user = getUser(userId);

    for (int following : user.getFollowing()) {
      User followingUser = getUser(following);

      ListIterator<Tweet> itr = followingUser.getLatestTweets();
      int count = 0;
      while (itr.hasNext() && count < 10) {
        tweets.add(itr.next());
        count++;
      }
    }

    int count = 0;
    while (!tweets.isEmpty() && count < 10) {
      result.add(tweets.poll().getTweetId());
      count++;
    }

    return result;
  }
  
  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    User user = getUser(followerId);
    user.follow(followeeId);
  }
  
  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    User user = getUser(followerId);
    user.unfollow(followeeId);
  }
}

class User {
  private int userId;
  private LinkedList<Tweet> tweets;
  private Set<Integer> following;

  public User(int userId) {
    this.userId = userId;
    tweets = new LinkedList<Tweet>();
    following = new HashSet<Integer>();

    follow(userId);
  }

  public ListIterator<Tweet> getLatestTweets() {
    return tweets.listIterator(0);
  }

  public Set<Integer> getFollowing() {
    return following;
  }

  public void tweet(int tweetId) {
    Tweet tweet = new Tweet(tweetId);
    tweets.addFirst(tweet);
  }

  public void follow(int followUserId) {
    following.add(followUserId);
  }

  public void unfollow(int unfollowUserId) {
    if (unfollowUserId != userId) {
      following.remove(unfollowUserId);
    }
  }
}

class Tweet implements Comparable<Tweet> {
  private int tweetId;
  private static int tweetCount = 0;
  private int tweetTime;

  public Tweet(int tweetId) {
    this.tweetId = tweetId;
    tweetTime = tweetCount;
    Tweet.tweetCount += 1;
  }

  public int getTweetId() {
    return tweetId;
  }

  public int compareTo(Tweet other) {
    return other.tweetTime - this.tweetTime;
  }
}
