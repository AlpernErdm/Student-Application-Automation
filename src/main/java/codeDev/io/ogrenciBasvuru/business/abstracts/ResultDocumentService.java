package codeDev.io.ogrenciBasvuru.business.abstracts;

import codeDev.io.ogrenciBasvuru.business.requests.CreateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllResultDocumentsResponse;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdResultDocumentResponse;

import java.util.List;

public interface ResultDocumentService {
    void add(CreateResultDocumentRequest createResultDocumentRequest);
    void delete(int id);
    void update(int id,UpdateResultDocumentRequest updateResultDocumentRequest);
    GetByIdResultDocumentResponse getById(int id);
    List<GetAllResultDocumentsResponse> getall();

}
