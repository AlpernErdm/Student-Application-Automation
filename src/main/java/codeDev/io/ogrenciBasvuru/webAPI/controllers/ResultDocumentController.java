package codeDev.io.ogrenciBasvuru.webAPI.controllers;

import codeDev.io.ogrenciBasvuru.business.abstracts.ResultDocumentService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdResultDocumentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/resultdocument")
@RequiredArgsConstructor
public class ResultDocumentController {
    private final ResultDocumentService resultDocumentService;


    @PostMapping()
    public void add(@RequestBody CreateResultDocumentRequest createResultDocumentRequest){
        this.resultDocumentService.add(createResultDocumentRequest);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UpdateResultDocumentRequest updateResultDocumentRequest){
        this.resultDocumentService.update(id,updateResultDocumentRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.resultDocumentService.delete(id);
    }
    @GetMapping("/{id}")
    public GetByIdResultDocumentResponse getById(@PathVariable int id){
    return resultDocumentService.getById(id);
    }


}
