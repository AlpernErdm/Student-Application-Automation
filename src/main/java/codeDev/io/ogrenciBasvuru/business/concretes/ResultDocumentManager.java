package codeDev.io.ogrenciBasvuru.business.concretes;

import codeDev.io.ogrenciBasvuru.business.abstracts.ResultDocumentService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllResultDocumentsResponse;
import codeDev.io.ogrenciBasvuru.core.utilities.mappers.ModelMapperService;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ApplicationRepository;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ResultDocumentRepository;
import codeDev.io.ogrenciBasvuru.entities.Application;
import codeDev.io.ogrenciBasvuru.entities.ResultDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ResultDocumentManager implements ResultDocumentService {
    private final ResultDocumentRepository resultDocumentRepository;
    private final ModelMapperService modelMapperService;
    private final ApplicationRepository applicationRepository;
    @Override
    public void add(CreateResultDocumentRequest createResultDocumentRequest) {
        Application application=this.applicationRepository.findById(createResultDocumentRequest.getApplicationId()).get();
        ResultDocument resultDocument=new ResultDocument();
//                this.modelMapperService.forRequest()
//                .map(createResultDocumentRequest,ResultDocument.class);
        resultDocument.setId(createResultDocumentRequest.getApplicationId());
        resultDocument.setScore(createResultDocumentRequest.getScore());
        resultDocument.setApplication(application);
        this.resultDocumentRepository.save(resultDocument);

    }

    @Override
    public void delete(int id) {
        this.resultDocumentRepository.deleteById(id);

    }

    @Override
    public void update(int id,UpdateResultDocumentRequest updateResultDocumentRequest) {
    ResultDocument resultDocument=this.resultDocumentRepository.findById(id).orElseThrow();
    resultDocument.setScore(updateResultDocumentRequest.getScore());
    }

    @Override
    public List<GetAllResultDocumentsResponse> getall() {
        List<ResultDocument>resultDocuments=this.resultDocumentRepository.findAll();
        return resultDocuments.stream()
                .map(resultDocument -> this.modelMapperService.forResponse()
                        .map(resultDocument,GetAllResultDocumentsResponse.class)).toList();
    }
}
