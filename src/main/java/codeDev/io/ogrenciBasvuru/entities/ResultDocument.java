package codeDev.io.ogrenciBasvuru.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne()
    @JoinColumn(name = "applicationId")
    private Application application;

}
