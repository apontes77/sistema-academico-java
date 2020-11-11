package net.javaguides.springboot.model.enums;

public enum Perfil {

    SECRETARIO(1, "ROLE_SECRET"),
    PROFESSOR(2, "ROLE_PROF"),
    COORDENADOR(3, "ROLE_ADMIN"),
    ALUNO(4, "ROLE_ALUNO");

    private int cod;
    private String descricao;

    private Perfil (int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod(){
        return cod;
    }

    public String getDescricao(){
        return descricao;
    }

    public static Perfil toEnum (Integer cod) {
        if (cod == null) {
            return null;
        }

        for(Perfil x: Perfil.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("ID Inválido: " + cod);
    }

}
