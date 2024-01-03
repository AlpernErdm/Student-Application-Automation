package codeDev.io.ogrenciBasvuru.dataAccess.abstracts.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Table(name = "applications")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "Id cannot be empty")
    @Size(min = 3,max = 20,message = "Name length size be 3 between 20")
    private int id;

    @Column(name = "createDate")
    @CreatedDate
    @NotBlank(message = "CreateDate cannot be empty")
    private Date createDate;

    @Column(name = "lastModified")
    @LastModifiedDate
    private Date lastModified;

    @Column(name = "countryOfResidence")
    @NotBlank(message = "Country of Residance cannot be empty")
    private String countryOfResidence;//yaşadığı ülke

    @Column(name = "desiredDepartment")
    private String desiredDepartment;// istenen bölüm

    @Column(name = "applicationYear")
    private int applicationYear;

    @ManyToOne()
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;



}
