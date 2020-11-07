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
public class Aluno extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Date dt_matricula;

    public Aluno() {
    }

    public Aluno(String nome, Date dt_nasc, String cpf, String email, Integer tipo_perfil, Integer id, Date dt_matricula) {
        super(nome, dt_nasc, cpf, email, tipo_perfil);
        this.id = id;
        this.dt_matricula = dt_matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDt_matricula() {
        return dt_matricula;
    }

    public void setDt_matricula(Date dt_matricula) {
        this.dt_matricula = dt_matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return id.equals(aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


