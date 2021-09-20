package application.rest.tweet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/tweet")
@CrossOrigin("*")
public class TweetController {

  @Autowired
  private TweetService tweetService;

  @GetMapping
  public List<Tweet> getTweets(@RequestParam(value = "hashtag") String hashtag) {

    if (hashtag == null) {
      return null;
    }

    List<Tweet> tweets = tweetService.getTweetsByHashtag(hashtag);

    return tweets;
  }
}
