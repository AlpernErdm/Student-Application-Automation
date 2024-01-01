package codeDev.io.ogrenciBasvuru.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidationProblemDetails extends ProblemDetails{

    private Map<String, String> validationErrors;

}
