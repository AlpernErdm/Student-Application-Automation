package codeDev.io.ogrenciBasvuru.dataAccess.abstracts;

import codeDev.io.ogrenciBasvuru.entities.Application;
import codeDev.io.ogrenciBasvuru.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    boolean existsByUserIdAndApplicationYear(Integer id,Integer applicationYear);

}
