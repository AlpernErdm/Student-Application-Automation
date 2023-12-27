package codeDev.io.ogrenciBasvuru.business.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetAllUsersResponse {
    private int id;
    private String name;
    private String surname;
    private Date createDate;
    private Date lastModified;
    private String email;


}
