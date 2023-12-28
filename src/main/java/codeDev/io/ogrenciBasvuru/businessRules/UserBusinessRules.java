package codeDev.io.ogrenciBasvuru.businessRules;

import codeDev.io.ogrenciBasvuru.core.utilities.mappers.exceptions.UserNotFoundException;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.UserRepository;
import codeDev.io.ogrenciBasvuru.core.utilities.mappers.exceptions.UserNameExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserBusinessRules {
    private UserRepository userRepository;

    public void checkIfUserNameExist(String name) {
        if (this.userRepository.existsByName(name)) {
            throw new UserNameExistException(String.format("User name already exists with %s", name));
        }
    }
    public void checkIfUserIdNotExists(Integer id) {
        if (this.userRepository.existsById(id)) {
            throw new UserNotFoundException(String.format("User not found %s", id));
        }
    }
}
