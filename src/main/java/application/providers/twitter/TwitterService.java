package application.providers.twitter;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.config.TwitterConfiguration;
import application.rest.tweet.Tweet;
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
public class TwitterService {
  
  @Autowired
  TwitterConfiguration twitterConfiguration;

  public List<Tweet> getTweetsByHashtag(String hashtag) {

    Twitter twitter = twitterConfiguration.configureTwitter();
    
    List<Tweet> tweets = new ArrayList<Tweet>();

		int count = 0;
    try {
			Query query = new Query(hashtag);
			query.setCount(100);
			QueryResult result;


			result = twitter.search(query);
			
			for (Status status : result.getTweets()) {
				count++;

				Double latitude;
				Double longitude;

				if(status.getGeoLocation() != null) {
					latitude = status.getGeoLocation().getLatitude();
					longitude = status.getGeoLocation().getLongitude();
				} else if (status.getPlace() != null) {
					GeoLocation[][] boundingBoxes = status.getPlace().getBoundingBoxCoordinates();

					GeoLocation boundingBox1 = boundingBoxes[0][0];
					latitude = boundingBox1.getLatitude();
					longitude = boundingBox1.getLongitude();
				} else {
					continue;
				}

				String tweetId = Long.toString(status.getId());
				String tweetHashtag = hashtag;
				String username = status.getUser().getScreenName();
				String profileImageURL = status.getUser().getProfileImageURL();
				String text = status.getText();
				Date createdAt = status.getCreatedAt();
				
				Tweet tweet = new Tweet(tweetHashtag, tweetId, username, text, latitude, longitude, createdAt, profileImageURL);

				tweets.add(tweet);
			}

		} catch (TwitterException te) {
				te.printStackTrace();
				System.out.println("Failed to search tweets: " + te.getMessage());
		}
		
		System.out.println("Tweets with geolocation");
		System.out.println(tweets.size());
		System.out.println("All Tweets");
		System.out.println(count);

    return tweets;
	}

}
