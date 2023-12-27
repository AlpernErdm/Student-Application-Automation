package codeDev.io.ogrenciBasvuru.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean //IOC'ye modelMapper ekledi
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
