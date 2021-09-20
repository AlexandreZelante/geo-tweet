package application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterConfiguration {
  @Value("${twitter.consumerapi.key}")
	private String apiKey;
	@Value("${twitter.consumerapi.secretKey}")
	private String apiSecretKey;
	@Value("${twitter.oauthaccess.token}")
	private String accessToken;
	@Value("${twitter.oauthaccess.tokenSecret}")
  private String accessTokenSecret;
  
	@Bean
	public Twitter configureTwitter() {
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true)
				.setOAuthConsumerKey(this.apiKey)
				.setOAuthConsumerSecret(this.apiSecretKey)
				.setOAuthAccessToken(this.accessToken)
				.setOAuthAccessTokenSecret(this.accessTokenSecret);

		TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
		return twitterFactory.getInstance();
	}
}
