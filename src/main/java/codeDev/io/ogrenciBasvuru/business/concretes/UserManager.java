package codeDev.io.ogrenciBasvuru.business.concretes;

import codeDev.io.ogrenciBasvuru.business.responses.GetByIdUserResponse;
import codeDev.io.ogrenciBasvuru.businessRules.UserBusinessRules;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.UserRepository;
import codeDev.io.ogrenciBasvuru.business.abstracts.UserService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateUserRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateUserRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllUsersResponse;
import codeDev.io.ogrenciBasvuru.core.mappers.ModelMapperService;
import codeDev.io.ogrenciBasvuru.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final UserBusinessRules userBusinessRules;


    @Override
    public void add(CreateUserRequest createUserRequest) {

        this.userBusinessRules.checkIfUserEmailExists(createUserRequest.getEmail());
        User user = this.modelMapperService.forRequest()
                .map(createUserRequest, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest, int id) {
        this.userBusinessRules.checkIfUserIdNotFound(id);

        User user = User.builder()
                .email(updateUserRequest.getEmail())
                .role(updateUserRequest.getRole())
                .name(updateUserRequest.getName())
                .surname(updateUserRequest.getSurname())
                .build();

        this.userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        this.userRepository.deleteById(id);

    }

    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = this.userRepository.findAll();
        return users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetAllUsersResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetByIdUserResponse getById(int id) {
        this.userBusinessRules.checkIfUserIdNotExists(id);
        User user = this.userRepository.findById(id).orElseThrow();

        return this.modelMapperService.forResponse().map(user, GetByIdUserResponse.class);
    }

    @Override
    public List<GetAllUsersResponse> getUsersPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<User> all = userRepository.findAll(pageable);

        return all.stream().map(user -> modelMapperService.forRequest().map(user, GetAllUsersResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<GetAllUsersResponse> getUsersPaginationAndSorting(Integer pageNumber, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<User>all=userRepository.findAll(pageable);

        return all.stream().map(user -> modelMapperService.forRequest().map(user,GetAllUsersResponse.class)).collect(Collectors.toList());
    }



}
