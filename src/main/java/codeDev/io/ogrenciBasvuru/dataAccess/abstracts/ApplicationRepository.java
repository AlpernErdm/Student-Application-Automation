package codeDev.io.ogrenciBasvuru.dataAccess.abstracts;

import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    boolean existsByUserIdAndApplicationYear(Integer id,Integer applicationYear);

}
