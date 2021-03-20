package com.tweetapp.bean.tweet;

import java.io.Serializable;

import lombok.Data;

@Data
public class TweetDto implements Serializable {
	private static final long serialVersionUID = -8969477625461780227L;

	private String message;
	private String userId;
	private String timeStamp;
	private int replies;
	private int likes;
}
