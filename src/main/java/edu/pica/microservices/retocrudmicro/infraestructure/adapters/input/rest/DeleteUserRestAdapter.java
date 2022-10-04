package edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest;

import edu.pica.microservices.retocrudmicro.application.useCase.DeleteUserUseCase;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.data.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class DeleteUserRestAdapter {

    private final DeleteUserUseCase deleteUserUseCase;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable @Valid Long id){
        log.info("Información de Invocación del Servicio de Eliminación de  Usuario por Id" );
        deleteUserUseCase.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
