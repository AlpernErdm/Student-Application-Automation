package codeDev.io.ogrenciBasvuru.businessRules;

import codeDev.io.ogrenciBasvuru.core.utilities.mappers.exceptions.ApplicationNotFoundException;
import codeDev.io.ogrenciBasvuru.core.utilities.mappers.exceptions.UserNotFoundException;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationBusinessRules {
    private ApplicationRepository applicationRepository;

    public void checkApplicationNotFound(Integer id) {
        if (!this.applicationRepository.existsById(id)) {
            throw new UserNotFoundException(String.format("Application not found %s", id));
        }
    }
}
