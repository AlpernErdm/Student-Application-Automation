package codeDev.io.ogrenciBasvuru.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdResultDocumentResponse {
    private int id;
    private int score;
}
