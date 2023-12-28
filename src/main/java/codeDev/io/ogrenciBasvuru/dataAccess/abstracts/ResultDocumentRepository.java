package codeDev.io.ogrenciBasvuru.dataAccess.abstracts;

import codeDev.io.ogrenciBasvuru.entities.Application;
import codeDev.io.ogrenciBasvuru.entities.ResultDocument;
import codeDev.io.ogrenciBasvuru.entities.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultDocumentRepository extends JpaRepository<ResultDocument, Integer> {
    @Query("SELECT b FROM Basvuru b WHERE b.ogrenci = :ogrenci AND YEAR(b.basvuruTarihi) = :year")
    List<Application> findByUserAndApplicationDate(@Param("user") User user, @Param("year") int year);

}
