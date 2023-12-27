package codeDev.io.ogrenciBasvuru.business.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateResultDocumentRequest {
    private int id;
    private int score;
    private int applicationId;
}
