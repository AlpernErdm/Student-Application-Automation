package codeDev.io.ogrenciBasvuru.webAPI.controllers;

import codeDev.io.ogrenciBasvuru.business.abstracts.UserService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateUserRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateUserRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllUsersResponse;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdUserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<String> add(@RequestBody @Valid CreateUserRequest createUserRequest) {

        this.userService.add(createUserRequest);
        return ResponseEntity.ok("Result document added successfully");

    }

    @GetMapping()
    public List<GetAllUsersResponse> getall() {
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdUserResponse getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {

        this.userService.delete(id);
        return ResponseEntity.ok("Result document deleted successfully");

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody @Valid UpdateUserRequest updateUserRequest) {

        this.userService.update(updateUserRequest, id);
        return ResponseEntity.ok("Result document updated successfully");
    }


    @RequestMapping(value = "/pagination/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public List<GetAllUsersResponse> users(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        return userService.getUsersPagination(pageNumber, pageSize);
    }

    @RequestMapping(value = "/paginationSort/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public List<GetAllUsersResponse> sortUser(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        return userService.getUsersPaginationAndSorting(pageNumber, pageSize);

    }

}
