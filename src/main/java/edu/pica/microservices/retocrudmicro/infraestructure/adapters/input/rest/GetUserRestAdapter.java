package edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest;

import edu.pica.microservices.retocrudmicro.application.useCase.GetUserUseCase;
import edu.pica.microservices.retocrudmicro.domain.model.User;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.data.response.UserResponse;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.mapper.UserRestMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class GetUserRestAdapter {

    private final GetUserUseCase getUserUseCase;
    private final UserRestMapper userRestMapper;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers(){
    log.info("Información de Invocación del Servicio de Obtención de Listado   Usuario" );
      List<User> users =  getUserUseCase.getUser();
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.add("Responded", "GetUserRestAdapter");
      return ResponseEntity.accepted().headers(httpHeaders).body(userRestMapper.toUserResponses(users));
    }

}
