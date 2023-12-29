package codeDev.io.ogrenciBasvuru.businessRules;

import codeDev.io.ogrenciBasvuru.core.utilities.mappers.exceptions.ResultNotFoundException;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ResultDocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResultDocumentBusinessRules {
    private  ResultDocumentRepository resultDocumentRepository;
    public void checkIfResultDocumentNotFound(Integer id){
        if(!this.resultDocumentRepository.existsById(id)){
            throw new ResultNotFoundException(String.format("Result document not found %s",id));
        }
    }
}
