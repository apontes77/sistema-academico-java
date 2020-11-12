package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Aluno;
import net.javaguides.springboot.model.Professor;
import net.javaguides.springboot.model.Turma;
import net.javaguides.springboot.repository.ProfessorRepositorio;
import net.javaguides.springboot.repository.TurmaRepositorio;
import net.javaguides.springboot.service.exceptions.DataIntegrityException;
import net.javaguides.springboot.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepositorio professorRepositorio;

    public Professor find(Integer id) {
        Optional<Professor> obj = professorRepositorio.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Professor.class.getName()));
    }

    public Professor insert (Professor p){
       p.setId(null);
        return professorRepositorio.save(p);

    }

    public Professor update (Professor p) {
       Professor newprofessor = find(p.getId());
        updateData(newprofessor, p);
        return professorRepositorio.save(newprofessor);

    }

    public void delete (Integer id) {
        try {
            professorRepositorio.deleteById(id);
        }
        catch (DataIntegrityException e){
            throw new DataIntegrityException("não é possível excluir professor inexistente");
        }
    }

    public List<Professor> findAll() {
        return professorRepositorio.findAll();
    }

    public void updateData(Professor newProfessor, Professor p){
        newProfessor.setNomeProfessor(p.getNomeProfessor());
    }
}
