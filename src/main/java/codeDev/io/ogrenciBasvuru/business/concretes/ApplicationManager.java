package codeDev.io.ogrenciBasvuru.business.concretes;

import codeDev.io.ogrenciBasvuru.business.abstracts.ApplicationService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateApplicationRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateApplicationsRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllApplicationsResponses;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdApplicationResponse;
import codeDev.io.ogrenciBasvuru.businessRules.ApplicationBusinessRules;
import codeDev.io.ogrenciBasvuru.core.Result.DataResult;
import codeDev.io.ogrenciBasvuru.core.Result.Result;
import codeDev.io.ogrenciBasvuru.core.Result.SuccessResult;
import codeDev.io.ogrenciBasvuru.core.exceptions.ApplicationNotFoundException;
import codeDev.io.ogrenciBasvuru.core.mappers.ModelMapperService;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.ApplicationRepository;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.UserRepository;
import codeDev.io.ogrenciBasvuru.entities.Application;
import codeDev.io.ogrenciBasvuru.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationManager implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ModelMapperService modelMapperService;
    private final UserRepository userRepository;
    private final ApplicationBusinessRules applicationBusinessRules;

    @Override
    public Result add(CreateApplicationRequest createApplicationRequest) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        this.applicationBusinessRules.checkTheUserHasAnApplicationException(createApplicationRequest.getUserId(), currentYear);
        User user = this.userRepository.findById(createApplicationRequest.getUserId()).get();

        Application application = Application.builder()
                .countryOfResidence(createApplicationRequest.getCountryOfResidence())
                .desiredDepartment(createApplicationRequest.getDesiredDepartment())
                .user(user)
                .applicationYear(currentYear)
                .build();
        applicationRepository.save(application);
        return new SuccessResult("Added");
    }

    @Override
    public Result delete(int id) {
        this.applicationRepository.deleteById(id);
        return new SuccessResult("Deleted ");
    }

    @Override
    public GetByIdApplicationResponse getById(int id) {
        this.applicationBusinessRules.checkApplicationNotFound(id);
        Application application = this.applicationRepository.findById(id).orElseThrow();
        return this.modelMapperService.forResponse().map(application, GetByIdApplicationResponse.class);
    }

    @Override
    public Result update(int id, UpdateApplicationsRequest updateApplicationsRequest, User user) {
        Application application = this.applicationRepository.findById(id).orElseThrow(() -> new ApplicationNotFoundException("Başvuru bulunamadı"));

        application.setDesiredDepartment(updateApplicationsRequest.getDesiredDepartment());
        application.setCountryOfResidence(updateApplicationsRequest.getCountryOfResidence());
        applicationRepository.save(application);
        return new SuccessResult("Updated");
    }

    @Override
    public List<GetAllApplicationsResponses> getall() {
        List<Application> applications = this.applicationRepository.findAll();
        return applications.stream()
                .map(application -> this.modelMapperService.forResponse()
                        .map(application, GetAllApplicationsResponses.class)).toList();
    }
}
