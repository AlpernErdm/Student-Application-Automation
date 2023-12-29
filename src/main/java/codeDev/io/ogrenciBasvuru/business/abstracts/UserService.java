package codeDev.io.ogrenciBasvuru.business.abstracts;

import codeDev.io.ogrenciBasvuru.business.requests.CreateUserRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateUserRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllUsersResponse;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdUserResponse;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.UserRepository;
import codeDev.io.ogrenciBasvuru.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    void add(CreateUserRequest createUserRequest);
    void update(UpdateUserRequest updateUserRequest, int id);
    void delete(int id);
    List<GetAllUsersResponse> getAll();
    GetByIdUserResponse getById(int id);
    Page<User> getUsersPagination(Integer pageNumber,Integer pageSize);
    Page<User> getUsersPaginationAndSorting(Integer pageNumber,Integer pageSize);
//    boolean userHasAppliedThisYear(User user);
//    boolean ogrenciHasResultDocumentThisYear(User user);
}
