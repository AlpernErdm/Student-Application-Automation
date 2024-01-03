package codeDev.io.ogrenciBasvuru.dataAccess.abstracts.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "Id cannot be empty")
    @Size(max = 20,min = 3,message = "Name length size be 3 between 20")
    private int id;

    @Column(name = "name")
    @Size(min = 3,max = 20,message = "The name can be between 3 and 20 characters")
    private String name;

    @Column(name = "surname")
    @Size(min = 3,max = 20,message = "Surname length size be 3 between 20")
    private String surname;

    @Column(name = "createDate")
    @CreatedDate
    private Date createDate; // LccalDateTime

    @Column(name = "lastModified")
    @LastModifiedDate
    private Date lastModified;

    @Column(name = "email",unique = true)
    @Size(min = 10,max = 50,message = "Email length size be 10 between 50")
    private String email;

    @Column(name = "role") //admin/user
    private String role;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Application>applications =new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<ResultDocument>resultDocument;




}
