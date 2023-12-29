package codeDev.io.ogrenciBasvuru.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetByIdUserResponse {
    private int id;
    private String name;
    private String surname;
    private Date createDate;
    private Date lastModified;
    private String email;
    private String role;
}
