package sistemaAcademico.service;


import sistemaAcademico.model.Disciplina;
import sistemaAcademico.repository.DisciplinaRepositorio;
import sistemaAcademico.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepositorio disciplinaRepositorio;

    public Disciplina insert (Disciplina d) {
        d.setIddisciplina(null);
        return disciplinaRepositorio.save(d);
    }

    public Disciplina find(Integer id){
        Optional<Disciplina> disciplina = disciplinaRepositorio.findById(id);
        return disciplina.orElseThrow(() -> new ObjectNotFoundException(
                "Disciplina não encontrada! Id: " +id+ ", Nome do Disciplina: " + Disciplina.class.getName()
        ));
    }

    public List<Disciplina> findAll(){
        return disciplinaRepositorio.findAll();
    }
}
