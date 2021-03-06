package net.javaguides.springboot.service;


import net.javaguides.springboot.model.Curso;
import net.javaguides.springboot.repository.CursoRepositorio;
import net.javaguides.springboot.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepositorio cursoRepositorio;

    public Curso insert (Curso c) {
        c.setIdcurso(null);
        return cursoRepositorio.save(c);
    }

    public Curso find(Integer id){
        Optional<Curso> curso = cursoRepositorio.findById(id);
        return curso.orElseThrow(() -> new ObjectNotFoundException(
                "Curso não encontrado! Id: " +id+ ", Nome do Curso: " + Curso.class.getName()
        ));
    }

    public List<Curso> findAll(){
        return cursoRepositorio.findAll();
    }

}
