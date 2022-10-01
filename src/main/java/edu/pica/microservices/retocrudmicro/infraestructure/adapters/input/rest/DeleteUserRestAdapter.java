package edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest;

import edu.pica.microservices.retocrudmicro.application.useCase.DeleteUserUseCase;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.data.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class DeleteUserRestAdapter {

    private final DeleteUserUseCase deleteUserUseCase;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable @Valid Long id){
        deleteUserUseCase.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
