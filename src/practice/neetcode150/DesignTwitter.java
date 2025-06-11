// https://leetcode.com/problems/design-twitter/

class Tweet implements Comparable<Tweet> {

    int time;
    int tweetId;
    public Tweet(int time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
    }
    public int compareTo(Tweet that) {
        return that.time  - this.time;
    }
}

class User {

    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;

    public User(int userId) {
         this.userId = userId;
         followers = new HashSet<>();
         followers.add(userId); // user follows themselves
         tweets = new LinkedList<>();   
    }

    public void addTweet(Tweet t) {
        // insertion at head
       tweets.add(0, t);
    }

    public void addFollower(int followeeId) {
        followers.add(followeeId);
    }

    public void removeFollower(int followeeId) {
        followers.remove(followeeId);
    }
    
}

class DesignTwitter {

    HashMap<Integer, User> userMap;
    int timeCounter = 0;

    public DesignTwitter() {
      userMap = new HashMap<>(); 
      timeCounter = 0; 
    }
    
    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        if(!userMap.containsKey(userId)) {
           userMap.put(userId, new User(userId));

        }

        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)) {
            return new ArrayList<>();
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        User user = userMap.get(userId);

        for(int followerId : user.followers) {
            int count = 0;
            for(Tweet tweet : userMap.get(followerId).tweets) {
                pq.offer(tweet);
                count++;
                if(count >= 10) {
                    break;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int index = 0;
        while(!pq.isEmpty() && index < 10) {
            Tweet tweet = pq.poll();
            result.add(tweet.tweetId);
            index++;
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {

        if(!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
         if(!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }

        User user = userMap.get(followerId);
        user.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) {
            return;
        }
        User user = userMap.get(followerId);
        user.removeFollower(followeeId);
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
