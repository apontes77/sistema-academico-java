package sistemaAcademico.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name="TB_NOTAS_FREQUENCIA")
public class DetalheAlunoTurma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "idaluno")
    private Integer idaluno;


    @Column(name = "idturma")
    private Integer idturma;

    private Double n1;

    private Double n2;

    private int frequencia;



    public DetalheAlunoTurma() {
    }

    public DetalheAlunoTurma(Integer id, Integer idaluno, Integer idturma, Double n1, Double n2, int frequencia) {
        this.id = id;
        this.idaluno = idaluno;
        this.idturma = idturma;
        this.n1 = n1;
        this.n2 = n2;
        this.frequencia = frequencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(Integer idaluno) {
        this.idaluno = idaluno;
    }

    public Integer getIdturma() {
        return idturma;
    }

    public void setIdturma(Integer idturma) {
        this.idturma = idturma;
    }

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalheAlunoTurma that = (DetalheAlunoTurma) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
