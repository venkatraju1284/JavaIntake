package interview.model;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TEDTALK_INFORMATION")
public class TedTalkInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String title;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(
//            name = "author_id",
//            referencedColumnName = "author_id"
//    )
    private String author;

    private Long likes;

    private Long views;

    private String urlInformation;

    private Date authorInteractionDate;

    public TedTalkInformation(@NonNull final String title, @NonNull final String author, final Long likes, final Long views, final String urlInformation, final Date authorInteractionDate) {
        if (title == null) {
            throw new NullPointerException("title is marked non-null but is null");
        } else if (author == null) {
            throw new NullPointerException("author is marked non-null but is null");
        } else {
            this.title = title;
            this.author = author;
            this.likes = likes;
            this.views = views;
            this.urlInformation = urlInformation;
            this.authorInteractionDate = authorInteractionDate;
        }
    }

}
