package application.rest.hashtag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.providers.twitter.TwitterService;
import application.rest.tweet.Tweet;
import application.rest.tweet.TweetService;

@RestController
@RequestMapping(value="/hashtag")
@CrossOrigin("*")
public class HashtagController {

  @Autowired
  private HashtagService hashtagService;

  @Autowired
  private TwitterService twitterService;

  @Autowired
  private TweetService tweetService;

  @GetMapping
  public List<Hashtag> getHashtags() {

    List<Hashtag> hashtags = hashtagService.getHashtags();

    return hashtags;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Tweet> addHashtag(@RequestBody Hashtag hashtag) {

    hashtagService.addHashtag(hashtag.getName());

    List<Tweet> filteredTweetsByHashtag = twitterService.getTweetsByHashtag(hashtag.getName());

    List<Tweet> tweetsWithSentiment = tweetService.addSentimentOnTweets(filteredTweetsByHashtag);

    List<Tweet> persistedTweets = tweetService.insertTweets(tweetsWithSentiment);

    return persistedTweets;
  }

  @DeleteMapping(value = "/{hashtag}")
  public void deleteHashtag(@PathVariable("hashtag") String hashtag) {

    hashtagService.deleteHashtag(hashtag);
    tweetService.deleteTweetsByHashtag(hashtag);
  }
}
