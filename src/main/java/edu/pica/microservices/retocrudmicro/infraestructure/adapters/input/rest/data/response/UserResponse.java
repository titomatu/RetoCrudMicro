package edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.data.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String email ;
    private String identificacion ;
    private String  nombre;
    private String apellido ;
    private Date fecha ;

}
