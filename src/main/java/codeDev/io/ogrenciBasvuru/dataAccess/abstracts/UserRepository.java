package codeDev.io.ogrenciBasvuru.dataAccess.abstracts;

import codeDev.io.ogrenciBasvuru.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByName(String name);
    boolean existsByEmail(String email);

    Page<User> findAll(Pageable pageable);

}
