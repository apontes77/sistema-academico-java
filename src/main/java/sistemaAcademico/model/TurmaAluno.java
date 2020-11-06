package sistemaAcademico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TURMA_ALUNO")
public class TurmaAluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "idaluno")
	private Integer idaluno;

	@Column(name = "idturma")
	private Integer idturma;

	@Column(name = "nota1")
	private Double nota1;

	@Column(name = "nota2")
	private Double nota2;

	@Column(name = "frequencia")
	private Integer frequencia;


	public TurmaAluno() {
	}

	public TurmaAluno(Integer idaluno, Integer idturma, Double nota1, Double nota2, Integer frequencia) {
		this.idaluno = idaluno;
		this.idturma = idturma;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.frequencia = frequencia;
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

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Integer getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
	}

}
