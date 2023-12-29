package codeDev.io.ogrenciBasvuru.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "resultDocument")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ResultDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "score")
    private int score;

    @Column(name = "resultDocumentYear")
    private Date resultDocumentYear;

    @ManyToOne()
    @JoinColumn(name = "applicationId")
    private Application application;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;
}
