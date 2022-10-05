package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "email")
    private String email ;
   @Column(name = "identificacion" , unique = true)
    private String identificacion ;
    @Column(name = "nombre")
    private String  nombre;
    @Column(name = "apellido")
    private String apellido ;
    @Column(name = "fecha")
    private Date fecha ;

}
