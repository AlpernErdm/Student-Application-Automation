package codeDev.io.ogrenciBasvuru.dataAccess.abstracts;

import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
    Page<User> findAll(Pageable pageable);
    boolean existsByRole(String role);

}
