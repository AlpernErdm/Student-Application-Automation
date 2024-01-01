package codeDev.io.ogrenciBasvuru.businessRules;

import codeDev.io.ogrenciBasvuru.core.exceptions.ResultDocumentNotFound;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ResultDocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResultDocumentBusinessRules {
    private  ResultDocumentRepository resultDocumentRepository;


    public void checkIfResultDocumentIdNotFound(Integer id){
        if(!this.resultDocumentRepository.existsById(id)){
            throw new ResultDocumentNotFound(String.format("Result Document not found this Id: %s",id));
        }
    }


}
