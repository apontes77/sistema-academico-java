package sistemaAcademico.model;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_ALUNO")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idaluno;

    @Column(name = "nome_aluno", nullable = false)
    private String nomeAluno;

    @Temporal(TemporalType.DATE)
    private Date dtnasc;

    @Temporal(TemporalType.DATE)
    private Date dtmatricula;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "numero_matricula", nullable = false)
    private Integer numeroMatricula;

    
    

    public Aluno(){}

    public Aluno(Integer idaluno, String nomeAluno, Date dtnasc, Date dtmatricula, String email, Integer numeroMatricula) {
        this.idaluno = idaluno;
        this.nomeAluno = nomeAluno;
        this.dtnasc = dtnasc;
        this.dtmatricula = dtmatricula;
        this.email = email;
        this.numeroMatricula = numeroMatricula;
    }


    public Integer getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(Integer idaluno) {
        this.idaluno = idaluno;
    }

    public Date getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(Date dtnasc) {
        this.dtnasc = dtnasc;
    }

    public Date getDtmatricula() {
        return dtmatricula;
    }

    public void setDtmatricula(Date dtmatricula) {
        this.dtmatricula = dtmatricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(idaluno, aluno.idaluno);
    }


    @Override
    public int hashCode() {
        return Objects.hash(idaluno);
    }
}

