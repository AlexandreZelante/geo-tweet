package application.rest.tweet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.providers.nlu.NLUService;

@Service
public class TweetService {

  @Autowired
  private TweetRepository tweetRepository;

  @Autowired
  NLUService nluService;

  public List<Tweet> getTweetsByHashtag(String hashtag){
    List<Tweet> tweets = tweetRepository.findByHashtag(hashtag);

    if(tweets.isEmpty()){
      return null;
    }
    
    return tweets;
  }

  public List<Tweet> insertTweets(List<Tweet> tweets) {
    List<Tweet> insertedTweets = tweetRepository.saveAll(tweets);

    return insertedTweets;
  }

  public List<Tweet> addSentimentOnTweets(List<Tweet> tweets) {

    for(Tweet tweet : tweets){
      String sentiment = nluService.getSentimentFromText(tweet.getText());

      tweet.setSentiment(sentiment);
    }
  
    return tweets;
  }

  public void deleteTweetsByHashtag(String hashtag) {
    tweetRepository.deleteByHashtag("#" + hashtag);
  }
}
