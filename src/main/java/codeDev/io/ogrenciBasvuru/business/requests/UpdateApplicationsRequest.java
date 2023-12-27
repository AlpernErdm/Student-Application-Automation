package codeDev.io.ogrenciBasvuru.business.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateApplicationsRequest {

    private String countryOfResidence;
    private String desiredDepartment;
    private int applicationYear;
}
