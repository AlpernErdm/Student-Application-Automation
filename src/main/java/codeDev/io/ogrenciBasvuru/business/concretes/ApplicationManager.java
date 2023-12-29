package codeDev.io.ogrenciBasvuru.business.concretes;

import codeDev.io.ogrenciBasvuru.business.abstracts.ApplicationService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateApplicationRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateApplicationsRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllApplicationsResponses;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdApplicationResponse;
import codeDev.io.ogrenciBasvuru.businessRules.ApplicationBusinessRules;
import codeDev.io.ogrenciBasvuru.core.utilities.mappers.ModelMapperService;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ApplicationRepository;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.UserRepository;
import codeDev.io.ogrenciBasvuru.entities.Application;
import codeDev.io.ogrenciBasvuru.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationManager implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ModelMapperService modelMapperService;
    private final UserRepository userRepository;
    private final ApplicationBusinessRules applicationBusinessRules;

    @Override
    public void add(CreateApplicationRequest createApplicationRequest) {
        User user = this.userRepository.findById(createApplicationRequest.getUserId()).get();

        Application application = new Application();
        application.setUser(user);
        application.setApplicationYear(createApplicationRequest.getApplicationYear());
        application.setCountryOfResidence(createApplicationRequest.getCountryOfResidence());
        application.setDesiredDepartment(createApplicationRequest.getDesiredDepartment());
        applicationRepository.save(application);

    }

    @Override
    public void delete(int id) {
        this.applicationRepository.deleteById(id);
    }

    @Override
    public GetByIdApplicationResponse getById(int id) {
        Application application=this.applicationRepository.findById(id).orElseThrow();
        this.applicationBusinessRules.checkApplicationNotFound(id);
        return this.modelMapperService.forResponse().map(application,GetByIdApplicationResponse.class);
    }

    @Override
    public void update(int id, UpdateApplicationsRequest updateApplicationsRequest, User user) {
        Application application = this.applicationRepository.findById(id).orElseThrow();
        application.setApplicationYear(updateApplicationsRequest.getApplicationYear());
        application.setDesiredDepartment(updateApplicationsRequest.getDesiredDepartment());
        application.setCountryOfResidence(updateApplicationsRequest.getCountryOfResidence());
        applicationRepository.save(application);

    }

    @Override
    public List<GetAllApplicationsResponses> getall() {
        List<Application> applications = this.applicationRepository.findAll();
        return applications.stream()
                .map(application -> this.modelMapperService.forResponse()
                        .map(application, GetAllApplicationsResponses.class)).toList();
    }
}
