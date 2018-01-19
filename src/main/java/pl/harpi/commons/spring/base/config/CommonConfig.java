package pl.harpi.commons.spring.base.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.harpi.commons.spring.base.types.ExceptionMapper;

@Configuration
public class CommonConfig {
    @Bean
    public ExceptionMapper mapper(MessageSource messageSource) {
        return new ExceptionMapper(messageSource);
    }
}
