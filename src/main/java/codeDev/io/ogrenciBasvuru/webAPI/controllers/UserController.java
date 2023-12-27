package codeDev.io.ogrenciBasvuru.webAPI.controllers;

import codeDev.io.ogrenciBasvuru.business.abstracts.UserService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateUserRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateUserRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
@Autowired
public UserController(UserService userService) {
    this.userService = userService;
}
@PostMapping()
public void add(@RequestBody CreateUserRequest createUserRequest){
    this.userService.add(createUserRequest);
}
@GetMapping()
public List<GetAllUsersResponse> getall(){
    return this.userService.getAll();
}
@DeleteMapping("/{id}")
public void delete(@PathVariable int id){
    this.userService.delete(id);
}
@PutMapping("/{id}")
public void update(@PathVariable int id ,@RequestBody UpdateUserRequest updateUserRequest){
    this.userService.update(updateUserRequest,id);
}

}
