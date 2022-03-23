package sit.int204.classicmodelsservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sit.int204.classicmodelsservice.properties.FileStorageProperties;
import sit.int204.classicmodelsservice.utils.ListMapper;

@Configuration
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class ApplicationConfig {
    @Bean
    public ListMapper listMapper() {
        return ListMapper.getInstance();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
