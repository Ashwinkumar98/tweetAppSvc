package com.tweetapp.bean.tweet;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "like")
@Data
public class LikeTweet implements Serializable {
	private static final long serialVersionUID = -4554507891230125261L;

	private String likeBy;
	private String tweetId;

}
