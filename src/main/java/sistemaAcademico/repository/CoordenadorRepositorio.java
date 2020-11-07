package sistemaAcademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistemaAcademico.model.Coordenador;
@Repository
public interface CoordenadorRepositorio extends JpaRepository<Coordenador, Integer> {
}
