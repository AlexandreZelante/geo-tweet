package application.config;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.natural_language_understanding.v1.NaturalLanguageUnderstanding;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WatsonNLUConfiguration {

  @Value("${watson.nlu.apikey}")
	private String apiKey;
	@Value("${watson.nlu.url}")
	private String url;
  
	@Bean
	public NaturalLanguageUnderstanding configureWatsonNLU() {

		IamAuthenticator authenticator = new IamAuthenticator(apiKey);

		NaturalLanguageUnderstanding naturalLanguageUnderstanding = new NaturalLanguageUnderstanding("2020-08-01", authenticator);
		
		naturalLanguageUnderstanding.setServiceUrl(url);

		return naturalLanguageUnderstanding;
	}
}
