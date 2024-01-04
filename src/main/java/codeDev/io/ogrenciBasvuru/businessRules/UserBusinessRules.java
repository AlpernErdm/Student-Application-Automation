package codeDev.io.ogrenciBasvuru.businessRules;

import codeDev.io.ogrenciBasvuru.core.exceptions.EmailAlreadyExistsException;
import codeDev.io.ogrenciBasvuru.core.exceptions.UserNotFoundException;
import codeDev.io.ogrenciBasvuru.core.exceptions.YouDoNotHavePermission;
import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserBusinessRules {
    private UserRepository userRepository;

    public void checkIfUserIdNotExists(Integer id) {
        if (!this.userRepository.existsById(id)) {
            throw new UserNotFoundException(String.format("User not found %s", id));
        }

    }

    public void checkIfUserEmailExists(String email) {
        if (this.userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
    }

    public void checkIfUserIdNotFound(Integer id) {
        if (!this.userRepository.existsById(id)) {
            throw new UserNotFoundException(String.format("There is no one with this ID: %s", id));
        }
    }

    public void checkYouHavePermission(String role) {
        if (!("admin".equals(role))) {
            throw new YouDoNotHavePermission("Invalid role for accessing data.");

        }

    }

    public void checkYouHavePermissionForAdd(String role) {
        if (!("admin".equals(role))) {
            throw new YouDoNotHavePermission("Invalid role for accessing data.");

        }
    }
}
