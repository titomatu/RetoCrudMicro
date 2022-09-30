package edu.pica.microservices.retocrudmicro.infraestructure.config;

import edu.pica.microservices.retocrudmicro.domain.service.CreateUserService;
import edu.pica.microservices.retocrudmicro.domain.service.GetUserService;
import edu.pica.microservices.retocrudmicro.domain.service.GetUserServiceById;
import edu.pica.microservices.retocrudmicro.domain.service.UpdateUserService;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.CreateUserPersintenceAdapter;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.GetUserPersistenceAdapter;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.GetUserPersistenceAdapterById;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.UpdateUserPersistenceAdapter;
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
    @Bean
    public CreateUserService createUserService(CreateUserPersintenceAdapter createUserPersintenceAdapter){
       return new CreateUserService(createUserPersintenceAdapter);
    }

    @Bean
    public GetUserPersistenceAdapter getUserPersistenceAdapter(UserRepository userRepository,UserPersinstenceMapper userPersinstenceMapper){
       return new GetUserPersistenceAdapter(userRepository,userPersinstenceMapper);
    }

    @Bean
    public GetUserService getUserService(GetUserPersistenceAdapter getUserPersistenceAdapter){
       return new GetUserService(getUserPersistenceAdapter);
    }

    @Bean
    public GetUserPersistenceAdapterById getUserPersistenceAdapterById(UserRepository userRepository,UserPersinstenceMapper userPersinstenceMapper){
       return new GetUserPersistenceAdapterById(userRepository,userPersinstenceMapper);
    }

    @Bean
    public GetUserServiceById getUserServiceById(GetUserPersistenceAdapterById getUserPersistenceAdapterById){
       return new GetUserServiceById(getUserPersistenceAdapterById);
    }

    @Bean
    public UpdateUserPersistenceAdapter updateUserPersistenceAdapter(UserRepository userRepository,UserPersinstenceMapper userPersinstenceMapper){
       return new UpdateUserPersistenceAdapter(userRepository,userPersinstenceMapper);
    }

    @Bean
    public UpdateUserService updateUserService(UpdateUserPersistenceAdapter updateUserPersistenceAdapter){
       return new UpdateUserService(updateUserPersistenceAdapter);
    }
}
