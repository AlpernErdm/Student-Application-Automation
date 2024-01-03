package codeDev.io.ogrenciBasvuru.dataAccess.abstracts;

import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface PaginationAndSortingRepository extends CrudRepository<User,Integer> {
    Iterable<User> findAll(Sort sort);
    Page<User>findAll(Pageable pageable);
}
