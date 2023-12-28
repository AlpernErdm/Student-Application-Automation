package codeDev.io.ogrenciBasvuru.businessRules;

import codeDev.io.ogrenciBasvuru.core.utilities.mappers.exceptions.ApplicationNotFoundException;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ApplicationRepository;

public class ApplicationBusinessRules {
    private ApplicationRepository applicationRepository;
    public void checkApplicationNotFound(Integer id){
        if(this.applicationRepository.existsById(id)){
            throw new ApplicationNotFoundException(String.format("Application not found"));
        }
    }

}
