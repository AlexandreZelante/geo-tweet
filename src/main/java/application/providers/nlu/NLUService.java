package application.providers.nlu;

import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.natural_language_understanding.v1.model.Features;
import com.ibm.watson.natural_language_understanding.v1.model.SentimentOptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.config.WatsonNLUConfiguration;

@Service
public class NLUService {

  @Autowired
  WatsonNLUConfiguration watsonNLUConfiguration;

  public String getSentimentFromText(String text) {

    try {

      NaturalLanguageUnderstanding naturalLanguageUnderstanding = watsonNLUConfiguration.configureWatsonNLU();

      SentimentOptions sentiment = new SentimentOptions.Builder().document(true).build();
      Features features = new Features.Builder().sentiment(sentiment).build();
      AnalyzeOptions parameters = new AnalyzeOptions.Builder().text(text).features(features).build();

      AnalysisResults response = naturalLanguageUnderstanding
      .analyze(parameters)
      .execute()
      .getResult();

      return response.getSentiment().getDocument().getLabel();
    } catch (ServiceResponseException e) {
      return "";
    } 
  } 
}
