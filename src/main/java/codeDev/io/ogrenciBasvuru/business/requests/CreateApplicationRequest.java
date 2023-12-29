package codeDev.io.ogrenciBasvuru.business.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateApplicationRequest {
    private String countryOfResidence;
    private String desiredDepartment;
    private LocalDate applicationYear;
    private int userId ;
}
