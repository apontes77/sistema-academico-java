package net.javaguides.springboot.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_TURMA")
public class Turma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="disciplina_id", nullable = false)
    private Disciplina disciplina;

    @Column(name = "nome_turma", nullable = false)
    private String nomeDaturma;

    @JsonIgnore
    @ManyToOne
    private Professor professor;

    public Turma(){}

    public Turma(Integer id, Disciplina disciplina, String nomeDaturma) {
        this.id = id;
        this.disciplina = disciplina;
        this.nomeDaturma = nomeDaturma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getNomeDaturma() {
        return nomeDaturma;
    }

    public void setNomeDaturma(String nomeDaturma) {
        this.nomeDaturma = nomeDaturma;
    }
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(id, turma.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}