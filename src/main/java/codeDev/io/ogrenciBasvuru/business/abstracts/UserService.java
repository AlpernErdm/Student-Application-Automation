package codeDev.io.ogrenciBasvuru.business.abstracts;

import codeDev.io.ogrenciBasvuru.business.requests.CreateUserRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateUserRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllUsersResponse;
import codeDev.io.ogrenciBasvuru.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    void add(CreateUserRequest createUserRequest);
    void update(UpdateUserRequest updateUserRequest, int id);
    void delete(int id);
    List<GetAllUsersResponse> getAll();

}
