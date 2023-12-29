package codeDev.io.ogrenciBasvuru.business.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreateUserRequest {
    @NotNull
    @NotBlank
    @Valid
    @Size(min = 2,max = 20)
    private String name;
    private String surname;
    private String email;
    private String role;

}
