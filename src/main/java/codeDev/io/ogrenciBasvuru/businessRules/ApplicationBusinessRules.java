package codeDev.io.ogrenciBasvuru.businessRules;

import codeDev.io.ogrenciBasvuru.core.exceptions.ApplicationNotFoundException;
import codeDev.io.ogrenciBasvuru.core.exceptions.ResultDocumentNotFound;
import codeDev.io.ogrenciBasvuru.core.exceptions.TheUserHasAnApplicationException;
import codeDev.io.ogrenciBasvuru.core.exceptions.UserNotFoundException;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationBusinessRules {
    private ApplicationRepository applicationRepository;

    public void checkApplicationNotFound(Integer id) {
        if (!this.applicationRepository.existsById(id)) {
            throw new ApplicationNotFoundException(String.format("Application not found %s", id));
        }
    }
    public void checkTheUserHasAnApplicationException(Integer id, int applicationYear){
        if(this.applicationRepository.existsByUserIdAndApplicationYear(id, applicationYear)) {
            throw new TheUserHasAnApplicationException("This user has an application :" + id);
        }
    }
}
