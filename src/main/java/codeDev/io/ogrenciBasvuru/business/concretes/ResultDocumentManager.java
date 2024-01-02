package codeDev.io.ogrenciBasvuru.business.concretes;

import codeDev.io.ogrenciBasvuru.business.abstracts.ResultDocumentService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllResultDocumentsResponse;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdResultDocumentResponse;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdUserResponse;
import codeDev.io.ogrenciBasvuru.businessRules.ResultDocumentBusinessRules;
import codeDev.io.ogrenciBasvuru.core.mappers.ModelMapperService;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ApplicationRepository;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ResultDocumentRepository;
import codeDev.io.ogrenciBasvuru.entities.Application;
import codeDev.io.ogrenciBasvuru.entities.ResultDocument;
import codeDev.io.ogrenciBasvuru.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultDocumentManager implements ResultDocumentService {
    private final ResultDocumentRepository resultDocumentRepository;
    private final ModelMapperService modelMapperService;
    private final ApplicationRepository applicationRepository;
    private final ResultDocumentBusinessRules resultDocumentBusinessRules;
    @Override
    public void add(CreateResultDocumentRequest createResultDocumentRequest) {
        Application application=this.applicationRepository.findById(createResultDocumentRequest.getApplicationId()).get();
        ResultDocument resultDocument=new ResultDocument();
                this.modelMapperService.forRequest()
                .map(createResultDocumentRequest,ResultDocument.class);
        resultDocument.setId(createResultDocumentRequest.getApplicationId());
        resultDocument.setScore(createResultDocumentRequest.getScore());
        resultDocument.setApplication(application);


        this.resultDocumentRepository.save(resultDocument);

    }

    @Override
    public void delete(int id) {
        this.resultDocumentBusinessRules.checkIfResultDocumentIdNotFound(id);

        this.resultDocumentRepository.deleteById(id);

    }

    @Override
    public void update(int id,UpdateResultDocumentRequest updateResultDocumentRequest) {
    ResultDocument resultDocument=this.resultDocumentRepository.findById(id).orElseThrow();
    resultDocument.setScore(updateResultDocumentRequest.getScore());
    this.resultDocumentRepository.save(resultDocument);
    }

    @Override
    public GetByIdResultDocumentResponse getById(int id) {

        this.resultDocumentBusinessRules.checkIfResultDocumentIdNotFound(id);
        ResultDocument resultDocument = this.resultDocumentRepository.findById(id).orElseThrow();
        return this.modelMapperService.forResponse().map(resultDocument, GetByIdResultDocumentResponse.class);
    }

    @Override
    public List<GetAllResultDocumentsResponse> getall() {
        List<ResultDocument>resultDocuments=this.resultDocumentRepository.findAll();
        return resultDocuments.stream()
                .map(resultDocument -> this.modelMapperService.forResponse()
                        .map(resultDocument,GetAllResultDocumentsResponse.class)).toList();
    }
}
