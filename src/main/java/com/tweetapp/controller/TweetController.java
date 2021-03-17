package com.tweetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.bean.tweet.Tweet;
import com.tweetapp.exception.TweetAppException;
import com.tweetapp.service.TweetService;

@RestController
public class TweetController {

	@Autowired
	private TweetService tweetService;

	@PostMapping("/add")
	public ResponseEntity<Tweet> postTweet(@RequestBody Tweet tweet) throws TweetAppException {
		return new ResponseEntity<Tweet>(tweetService.saveTweet(tweet), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Tweet>> getAllTweets() throws TweetAppException {
		return new ResponseEntity<>(tweetService.getAllTweetsByUserId(), HttpStatus.OK);
	}

}
