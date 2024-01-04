package codeDev.io.ogrenciBasvuru.business.abstracts;

import codeDev.io.ogrenciBasvuru.business.requests.CreateApplicationRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateApplicationsRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllApplicationsResponses;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdApplicationResponse;
import codeDev.io.ogrenciBasvuru.core.Result.DataResult;
import codeDev.io.ogrenciBasvuru.core.Result.Result;
import codeDev.io.ogrenciBasvuru.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ApplicationService {
    Result add(CreateApplicationRequest createApplicationRequest);
    Result delete(int id);
    GetByIdApplicationResponse getById(int id);
    Result update(int id, UpdateApplicationsRequest updateApplicationsRequest, User user);
    List<GetAllApplicationsResponses> getall();

}
