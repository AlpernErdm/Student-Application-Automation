package codeDev.io.ogrenciBasvuru.business.requests;

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
    @Size(min = 2, max = 20)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String surname;

    @NotNull
    @NotBlank
    @Size(min = 2,max = 50)
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 3,max = 6)
    private String role;

}
