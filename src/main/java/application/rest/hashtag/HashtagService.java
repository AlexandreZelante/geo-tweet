package application.rest.hashtag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HashtagService {

  @Autowired
  private HashtagRepository hashtagRepository;

  public List<Hashtag> getHashtags(){
    
    List<Hashtag> hashtags = hashtagRepository.findAll();

    if(hashtags.isEmpty()){
      return null;
    }
    
    return hashtags;
  }

  public Hashtag addHashtag(String hashtag) {

    Hashtag newHashtag = hashtagRepository.save(new Hashtag(hashtag));

    return newHashtag;
  }

  public void deleteHashtag(String hashtag) {
    hashtagRepository.deleteByName("#" + hashtag);
  }
}
