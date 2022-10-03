package edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.repository;
import edu.pica.microservices.retocrudmicro.infraestructure.adapters.output.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
