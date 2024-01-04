package codeDev.io.ogrenciBasvuru.webAPI.controllers;

import codeDev.io.ogrenciBasvuru.business.abstracts.ResultDocumentService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllResultDocumentsResponse;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdResultDocumentResponse;
import codeDev.io.ogrenciBasvuru.businessRules.UserBusinessRules;
import codeDev.io.ogrenciBasvuru.core.Result.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/resultdocument")
@RequiredArgsConstructor
public class ResultDocumentController {
    private final ResultDocumentService resultDocumentService;
    private final UserBusinessRules userBusinessRules;


    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Result> add(@RequestBody @Valid CreateResultDocumentRequest createResultDocumentRequest,@RequestParam(name = "role") String role) {
        this.userBusinessRules.checkYouHavePermission(role);
        return ResponseEntity.ok().body(resultDocumentService.add(createResultDocumentRequest));

    }
    @GetMapping("/all")
    @ResponseBody
    public List<GetAllResultDocumentsResponse> getAllResult(@RequestParam(name = "role") String role) {
        this.userBusinessRules.checkYouHavePermission(role);
        return resultDocumentService.getall(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody @Valid UpdateResultDocumentRequest updateResultDocumentRequest) {
            this.resultDocumentService.update(id, updateResultDocumentRequest);
            return ResponseEntity.ok("Result document updated successfully");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {

            this.resultDocumentService.delete(id);
            return ResponseEntity.ok("Result document deleted successfully");

    }

    @GetMapping("/{id}")
    public GetByIdResultDocumentResponse getById(@PathVariable int id) {
        return resultDocumentService.getById(id);
    }




}
