package application.rest.tweet;

import java.util.Date;

public class Tweet {
  private String hashtag;
  private String tweetId;
  private String username;
  private String text;
  private String sentiment;
  private double latitude;
  private double longitude;
  private Date createdAt;
  private String profileImageURL;

  public Tweet() {}

  public Tweet(String hashtag, String tweetId, String username, String text, String sentiment, double latitude,
    double longitude, Date createdAt, String profileImageURL) {
    this.hashtag = hashtag;
    this.tweetId = tweetId;
    this.username = username;
    this.text = text;
    this.sentiment = sentiment;
    this.latitude = latitude;
    this.longitude = longitude;
    this.createdAt = createdAt;
    this.profileImageURL = profileImageURL;
  }

  public Tweet(String hashtag, String tweetId, String username, String text, double latitude, double longitude,
    Date createdAt, String profileImageURL) {
    this.hashtag = hashtag;
    this.tweetId = tweetId;
    this.username = username;
    this.text = text;
    this.latitude = latitude;
    this.longitude = longitude;
    this.createdAt = createdAt;
    this.profileImageURL = profileImageURL;
  }

  public Tweet(String hashtag, String tweetId, String username, String text, Date createdAt, String profileImageURL) {
    this.hashtag = hashtag;
    this.tweetId = tweetId;
    this.username = username;
    this.text = text;
    this.createdAt = createdAt;
    this.profileImageURL = profileImageURL;
  }

  public String getHashtag() {
    return hashtag;
  }

  public void setHashtag(String hashtag) {
    this.hashtag = hashtag;
  }

  public String getTweetId() {
    return tweetId;
  }

  public void setTweetId(String tweetId) {
    this.tweetId = tweetId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSentiment() {
    return sentiment;
  }

  public void setSentiment(String sentiment) {
    this.sentiment = sentiment;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getProfileImageURL() {
    return profileImageURL;
  }

  public void setProfileImageURL(String profileImageURL) {
    this.profileImageURL = profileImageURL;
  }

}
