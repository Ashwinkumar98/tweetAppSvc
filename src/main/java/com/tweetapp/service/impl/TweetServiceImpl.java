package com.tweetapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.bean.tweet.Tweet;
import com.tweetapp.dao.TweetDao;
import com.tweetapp.exception.TweetAppException;
import com.tweetapp.service.TweetService;
import com.tweetapp.utils.UserUtil;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetDao tweetRepository;

	@Override
	public Tweet saveTweet(Tweet tweet) throws TweetAppException {
		tweet.setUserId(UserUtil.getUserName());
		Optional<Tweet> tweetData = tweetRepository.saveTweet(tweet);
		if (tweetData.isPresent()) {
			return tweetData.get();
		}
		throw new TweetAppException("Something went wrong while posting tweet");
	}

	@Override
	public List<Tweet> getAllTweetsByUserId() {
		return tweetRepository.getTweetsByUser();
	}
}
