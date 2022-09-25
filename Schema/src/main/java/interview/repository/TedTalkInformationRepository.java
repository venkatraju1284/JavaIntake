package interview.repository;

import interview.model.TedTalkInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TedTalkInformationRepository extends JpaRepository<TedTalkInformation, Long> {
    List<TedTalkInformation> findTop10ByLikesBetweenOrderByLikesDesc(Long fromNoOfLikes, Long toNoOfLikes);

    List<TedTalkInformation> findTop10ByTitleIgnoreCase(String title);

    List<TedTalkInformation> findTop10ByAuthorIgnoreCase(String author);

    List<TedTalkInformation> findTop10ByViewsBetweenOrderByViewsDesc(Long fromNoOfShares, Long toNoOfShares);
}
