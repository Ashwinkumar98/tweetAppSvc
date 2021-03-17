package com.tweetapp.dao;

import java.util.List;
import java.util.Optional;

import com.tweetapp.bean.tweet.Tweet;

public interface TweetDao {
	Optional<Tweet> saveTweet(Tweet tweet);

	List<Tweet> getTweetsByUser();
}
