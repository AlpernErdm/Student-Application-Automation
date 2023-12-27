package codeDev.io.ogrenciBasvuru.webAPI.controllers;

import codeDev.io.ogrenciBasvuru.business.abstracts.ResultDocumentService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllResultDocumentsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/resultdocument")
public class ResultDocumentController {
    private final ResultDocumentService resultDocumentService;
    public ResultDocumentController(ResultDocumentService resultDocumentService) {
        this.resultDocumentService = resultDocumentService;
    }
    @PostMapping()
    public void add(@RequestBody CreateResultDocumentRequest createResultDocumentRequest){
        this.resultDocumentService.add(createResultDocumentRequest);
    }
    @GetMapping()
    public List<GetAllResultDocumentsResponse>getall(){
        return resultDocumentService.getall();
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UpdateResultDocumentRequest updateResultDocumentRequest){
        this.resultDocumentService.update(id,updateResultDocumentRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.resultDocumentService.delete(id);
    }


}
