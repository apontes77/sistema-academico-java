package net.javaguides.springboot.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_PROFESSOR")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_professor")
    private String nomeProfessor;
    @JsonIgnore
   @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private Set<Turma> turmas = new HashSet<>();

    public Professor() {}

    public Professor(Integer id, String nomeProfessor) {
        this.id = id;
        this.nomeProfessor = nomeProfessor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public Set<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }
}
