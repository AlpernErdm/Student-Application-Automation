package codeDev.io.ogrenciBasvuru.businessRules;

import codeDev.io.ogrenciBasvuru.core.exceptions.ResultNotFoundException;
import codeDev.io.ogrenciBasvuru.core.exceptions.UserNotFoundException;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ApplicationBusinessRules {
    private ApplicationRepository applicationRepository;

    public void checkApplicationNotFound(Integer id) {
        if (!this.applicationRepository.existsById(id)) {
            throw new UserNotFoundException(String.format("Application not found %s", id));
        }
    }
    public void checkTheUserHasAnApplicationException(Integer id, LocalDate applicationYear){
        if(this.applicationRepository.existsByUserIdAndApplicationYear(id,applicationYear.getYear())) {
            throw new ResultNotFoundException("This user has an application :" + id);
        }
    }
}
