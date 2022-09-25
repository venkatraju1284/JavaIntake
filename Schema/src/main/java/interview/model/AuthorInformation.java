package interview.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorInformation {

    @Id
    @SequenceGenerator(
            name = "author_id",
            sequenceName = "author_id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id")
    @Column(name = "author_id")
    private Long authorId;

    private String author;

//    @OneToMany(targetEntity = TedTalkInformation.class)
//    @JoinColumn( name = "author_Id",
//            referencedColumnName = "authorId")
//    private List<TedTalkInformation> tedTalkInformationList;


}
