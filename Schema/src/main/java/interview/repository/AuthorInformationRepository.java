package interview.repository;

import interview.model.AuthorInformation;
import interview.model.TedTalkInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorInformationRepository extends JpaRepository<AuthorInformation, Long> {

    List<TedTalkInformation> findByAuthor(String author);
}
