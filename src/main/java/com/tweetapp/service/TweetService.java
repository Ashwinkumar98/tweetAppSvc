package com.tweetapp.service;

import java.util.List;

import com.tweetapp.bean.tweet.Tweet;
import com.tweetapp.exception.TweetAppException;

public interface TweetService {
	Tweet saveTweet(Tweet tweet) throws TweetAppException;

	List<Tweet> getAllTweetsByUserId();
}
