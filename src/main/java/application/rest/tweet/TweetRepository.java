package application.rest.tweet;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface TweetRepository extends MongoRepository<Tweet, String>{
  List<Tweet> findByHashtag(@Param("hashtag") String hashtag);
  void deleteByHashtag(String hashtag);
}
