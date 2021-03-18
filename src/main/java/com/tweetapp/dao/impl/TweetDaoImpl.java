package com.tweetapp.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tweetapp.bean.tweet.LikeTweet;
import com.tweetapp.bean.tweet.ReplyTweet;
import com.tweetapp.bean.tweet.Tweet;
import com.tweetapp.dao.TweetDao;
import com.tweetapp.utils.UserUtil;

@Repository
public class TweetDaoImpl implements TweetDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Optional<Tweet> saveTweet(Tweet tweet) {
		return Optional.of(mongoTemplate.save(tweet));
	}

	@Override
	public List<Tweet> getAllTweets() {
		return mongoTemplate.findAll(Tweet.class);
	}

	@Override
	public ReplyTweet saveReply(ReplyTweet reply) {
		reply.setUserId(UserUtil.getUserName());
		return mongoTemplate.save(reply);
	}

	@Override
	public List<ReplyTweet> getAllReply(String tweetId) {
		return mongoTemplate.find(Query.query(Criteria.where("tweetId").is(tweetId)), ReplyTweet.class);
	}

	@Override
	public LikeTweet saveLike(LikeTweet likeTweet) {
		return mongoTemplate.save(likeTweet);
	}

}
