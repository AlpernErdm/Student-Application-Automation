package codeDev.io.ogrenciBasvuru.business.abstracts;

import codeDev.io.ogrenciBasvuru.business.requests.CreateApplicationRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateApplicationsRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllApplicationsResponses;
import codeDev.io.ogrenciBasvuru.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ApplicationService {
    void add(CreateApplicationRequest createApplicationRequest);
    void delete(int id);
    void update(int id, UpdateApplicationsRequest updateApplicationsRequest, User user);
    List<GetAllApplicationsResponses> getall();

}
