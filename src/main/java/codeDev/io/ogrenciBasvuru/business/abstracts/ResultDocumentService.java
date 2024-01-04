package codeDev.io.ogrenciBasvuru.business.abstracts;

import codeDev.io.ogrenciBasvuru.business.requests.CreateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllResultDocumentsResponse;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdResultDocumentResponse;
import codeDev.io.ogrenciBasvuru.core.Result.Result;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ResultDocumentService {
    Result add(CreateResultDocumentRequest createResultDocumentRequest);
    Result delete(int id);
    Result update(int id,UpdateResultDocumentRequest updateResultDocumentRequest);
    GetByIdResultDocumentResponse getById(int id);
    List<GetAllResultDocumentsResponse> getall(String role);

}
