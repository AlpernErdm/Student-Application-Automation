package codeDev.io.ogrenciBasvuru.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Table(name = "resultDocument")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class ResultDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "Id cannot be empty")
    @Size(min = 3,max = 20,message = "Name length  be 3 between 20")
    private int id;

    @Column(name = "score")
    @Size(min = 2,max = 3,message = "Score length be 0 between 500")
    private int score;

    @Column(name = "resultDocumentYear")
    @NotBlank(message = "Result Document cannot be empty")
    private Date resultDocumentYear;

    @ManyToOne()
    @JoinColumn(name = "applicationId")
    private Application application;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;
}
