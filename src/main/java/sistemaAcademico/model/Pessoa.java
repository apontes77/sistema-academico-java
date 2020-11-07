package sistemaAcademico.model;

import java.io.Serializable;
import java.util.Date;

public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;

    private Date dt_nasc;

    private String cpf;

    private String email;

    private Integer tipo_perfil;

    public Pessoa () {}

    public Pessoa(String nome, Date dt_nasc, String cpf, String email, Integer tipo_perfil) {
        this.nome = nome;
        this.dt_nasc = dt_nasc;
        this.tipo_perfil = tipo_perfil;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Date getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(Date dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public Integer getTipo_perfil() {
        return tipo_perfil;
    }

    public void setTipo_perfil(Integer tipo_perfil) {
        this.tipo_perfil = tipo_perfil;
    }


}
