package codeDev.io.ogrenciBasvuru.business.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllApplicationsResponses {
    private int id;
    private Date createDate;
    private Date lastModified;
    private String countryOfResidence;
    private String desiredDepartment;
    private int applicationYear;




}
