package interview.web;

import interview.model.TedTalkInformation;
import interview.repository.TedTalkInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TedTalkInformationWebServie {

    @Autowired
    private TedTalkInformationRepository tedTalkInformationRepository;

    public TedTalkInformation addTedTalk(TedTalkInformation tedTalkInformation) {

        return tedTalkInformationRepository.save(tedTalkInformation);
    }

    public Optional<TedTalkInformation> findTedTalkById(Long id) {

        return tedTalkInformationRepository.findById(id);
    }

    public List<TedTalkInformation> findTedTalksByAuthor(String author) {
        return tedTalkInformationRepository.findTop10ByAuthorIgnoreCase(author);
    }

    public List<TedTalkInformation> findTedTalksByTitle(String title) {

        return tedTalkInformationRepository.findTop10ByTitleIgnoreCase(title);
    }

    public List<TedTalkInformation> findTedTalksByLikes(Long fromNoOfLikes, Long toNoOfLikes) {

        return tedTalkInformationRepository.findTop10ByLikesBetweenOrderByLikesDesc(fromNoOfLikes, toNoOfLikes);
    }

    public List<TedTalkInformation> findTedTalksByViews(Long fromNoOfViews, Long toNoOfViews) {

        return tedTalkInformationRepository.findTop10ByViewsBetweenOrderByViewsDesc(fromNoOfViews, toNoOfViews);
    }

    public TedTalkInformation updateTedTalk(Long id, TedTalkInformation userInformation) {

        return tedTalkInformationRepository.save(userInformation);
    }

    public String removeTedTalk(Long id) {

        tedTalkInformationRepository.deleteById(id);

        return new StringBuilder().append("Removed TedTalk with ID:").append(id).toString();
    }
}
