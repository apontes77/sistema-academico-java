package sistemaAcademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistemaAcademico.model.Secretario;

@Repository
public interface SecretarioRepositorio extends JpaRepository <Secretario, Integer> {
}
