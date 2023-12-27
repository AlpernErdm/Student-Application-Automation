package codeDev.io.ogrenciBasvuru.webAPI.controllers;

import codeDev.io.ogrenciBasvuru.business.abstracts.ApplicationService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateApplicationRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateApplicationsRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllApplicationsResponses;
import codeDev.io.ogrenciBasvuru.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @GetMapping()
    public List<GetAllApplicationsResponses> getall() {
        return applicationService.getall();

    }

    @PostMapping()
    public void add(@RequestBody CreateApplicationRequest createApplicationRequest) {
        this.applicationService.add(createApplicationRequest);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UpdateApplicationsRequest updateApplicationsRequest, User user) {
        this.applicationService.update(id, updateApplicationsRequest, user);
    }
@DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.applicationService.delete(id);
    }
}
