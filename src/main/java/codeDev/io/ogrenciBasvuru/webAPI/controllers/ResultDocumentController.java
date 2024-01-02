package codeDev.io.ogrenciBasvuru.webAPI.controllers;

import codeDev.io.ogrenciBasvuru.business.abstracts.ResultDocumentService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateResultDocumentRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllResultDocumentsResponse;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdResultDocumentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/resultdocument")
@RequiredArgsConstructor
public class ResultDocumentController {
    private final ResultDocumentService resultDocumentService;


    @PostMapping
    public ResponseEntity<String> add(@RequestBody @Valid CreateResultDocumentRequest createResultDocumentRequest) {
        try {
            this.resultDocumentService.add(createResultDocumentRequest);
            return ResponseEntity.ok("Result document added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong : " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody @Valid UpdateResultDocumentRequest updateResultDocumentRequest) {
        try {
            this.resultDocumentService.update(id, updateResultDocumentRequest);
            return ResponseEntity.ok("Result document updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong : " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            this.resultDocumentService.delete(id);
            return ResponseEntity.ok("Result document deleted successfully");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong: "+e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public GetByIdResultDocumentResponse getById(@PathVariable int id) {
        return resultDocumentService.getById(id);
    }

    @GetMapping()
    @ResponseBody
    public List<GetAllResultDocumentsResponse> getAllResult(@RequestParam(name = "admin")String role){
        return  resultDocumentService.getall();

    }


}
