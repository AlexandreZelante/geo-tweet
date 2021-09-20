package application.rest.hashtag;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HashtagRepository extends MongoRepository<Hashtag, String>{  
  void deleteByName(String name);
}
