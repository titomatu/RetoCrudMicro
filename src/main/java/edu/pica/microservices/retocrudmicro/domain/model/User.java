package edu.pica.microservices.retocrudmicro.domain.model;


import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String email ;
    private String identificacion ;
    private String  nombre;
    private String apellido ;
    private Date fecha ;

}
