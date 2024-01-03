package codeDev.io.ogrenciBasvuru.dataAccess.abstracts;

import codeDev.io.ogrenciBasvuru.dataAccess.abstracts.entities.ResultDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultDocumentRepository extends JpaRepository<ResultDocument, Integer> {



}
