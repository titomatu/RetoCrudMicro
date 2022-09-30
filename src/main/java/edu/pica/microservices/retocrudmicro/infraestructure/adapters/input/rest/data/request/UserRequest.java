package edu.pica.microservices.retocrudmicro.infraestructure.adapters.input.rest.data.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import java.util.Date;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private Long id;
    @NotEmpty(message = "Email may not be empty")
    private String email ;
    @NotEmpty(message = "Identificacion may not be empty")
    private String identificacion ;
    @NotEmpty(message = "Nombre may not be empty")
    private String  nombre;
    @NotEmpty(message = "Apellido may not be empty")
    private String apellido ;
    private Date fecha ;

}
