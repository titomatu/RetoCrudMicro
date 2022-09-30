package edu.pica.microservices.retocrudmicro.infraestructure.config;

import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.CreateUserPersintenceAdapter;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.mapper.UserPersinstenceMapper;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateUserPersintenceAdapter createUserPersintenceAdapter(UserRepository userRepository, UserPersinstenceMapper userPersinstenceMapper){
        return new CreateUserPersintenceAdapter(userRepository,userPersinstenceMapper);
    }
}
