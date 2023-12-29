package codeDev.io.ogrenciBasvuru.businessRules;

import codeDev.io.ogrenciBasvuru.business.requests.CreateApplicationRequest;
import codeDev.io.ogrenciBasvuru.core.exceptions.ResultNotFoundException;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ApplicationRepository;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ResultDocumentRepository;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResultDocumentBusinessRules {
    private  ResultDocumentRepository resultDocumentRepository;

    public void checkIfResultDocumentNotFound(Integer id){
        if(this.resultDocumentRepository.existsById(id)){
            throw new ResultNotFoundException(String.format("Result document not found %s",id));
        }
    }

}
