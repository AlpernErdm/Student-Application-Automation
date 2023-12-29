package codeDev.io.ogrenciBasvuru.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "applications")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "createDate")
    @CreatedDate
    private Date createDate;

    @Column(name = "lastModified")
    @LastModifiedDate
    private Date lastModified;

    @Column(name = "countryOfResidence")
    private String countryOfResidence;//yaşadığı ülke

    @Column(name = "desiredDepartment")
    private String desiredDepartment;// istenen bölüm

    @Column(name = "applicationYear")
    private int applicationYear;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;


}
