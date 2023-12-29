package codeDev.io.ogrenciBasvuru.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetByIdApplicationResponse {
    private int id;
    private Date createDate;
    private Date lastModified;
    private String countryOfResidence;
    private String desiredDepartment;
    private int applicationYear;
}
