package codeDev.io.ogrenciBasvuru.business.concretes;

import codeDev.io.ogrenciBasvuru.business.abstracts.ResultDocumentService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllResultDocumentsResponse;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdResultDocumentResponse;
import codeDev.io.ogrenciBasvuru.businessRules.ResultDocumentBusinessRules;
import codeDev.io.ogrenciBasvuru.businessRules.UserBusinessRules;
import codeDev.io.ogrenciBasvuru.core.Result.Result;
import codeDev.io.ogrenciBasvuru.core.Result.SuccessResult;
import codeDev.io.ogrenciBasvuru.core.exceptions.ApplicationNotFoundException;
import codeDev.io.ogrenciBasvuru.core.mappers.ModelMapperService;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ApplicationRepository;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ResultDocumentRepository;
import codeDev.io.ogrenciBasvuru.entities.Application;
import codeDev.io.ogrenciBasvuru.entities.ResultDocument;
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
    private final UserBusinessRules userBusinessRules;

    @Override
    public Result add(CreateResultDocumentRequest createResultDocumentRequest) {
        this.userBusinessRules.checkYouHavePermissionForAdd(createResultDocumentRequest.getRole());
        Application application = this.applicationRepository.findById(createResultDocumentRequest.getApplicationId()).
                orElseThrow(()->new ApplicationNotFoundException("Application not found"));
        ResultDocument resultDocument = new ResultDocument();
        this.modelMapperService.forRequest()
                .map(createResultDocumentRequest, ResultDocument.class);
        resultDocument.setId(createResultDocumentRequest.getApplicationId());
        resultDocument.setScore(createResultDocumentRequest.getScore());
        resultDocument.setApplication(application);


        this.resultDocumentRepository.save(resultDocument);
        return new SuccessResult("Added successfully");

    }

    @Override
    public Result delete(int id) {
        this.resultDocumentBusinessRules.checkIfResultDocumentIdNotFound(id);

        this.resultDocumentRepository.deleteById(id);
        return new SuccessResult("Deleted successfully");

    }

    @Override
    public Result update(int id, UpdateResultDocumentRequest updateResultDocumentRequest) {
        ResultDocument resultDocument = this.resultDocumentRepository.findById(id).orElseThrow();
        resultDocument.setScore(updateResultDocumentRequest.getScore());
        this.resultDocumentRepository.save(resultDocument);
        return new SuccessResult("Updated successfully");

    }

    @Override
    public GetByIdResultDocumentResponse getById(int id) {

        this.resultDocumentBusinessRules.checkIfResultDocumentIdNotFound(id);
        ResultDocument resultDocument = this.resultDocumentRepository.findById(id).orElseThrow();
        return this.modelMapperService.forResponse().map(resultDocument, GetByIdResultDocumentResponse.class);
    }

    @Override
    public List<GetAllResultDocumentsResponse> getall(String role) {
        this.userBusinessRules.checkYouHavePermission(role);

        List<ResultDocument> resultDocuments = this.resultDocumentRepository.findAll();
        return resultDocuments.stream()
                .map(resultDocument -> this.modelMapperService.forResponse()
                        .map(resultDocument, GetAllResultDocumentsResponse.class)).toList();
    }
}
