package net.javaguides.springboot.service.validations;

public class CalcularAprovacao {

    public boolean calcAprovacao(double n1, double n2, int frequencia) {
        double media;
        boolean resultado;

        if (frequencia < 90) {
            resultado = false;
        } else {
            media = (n1 + n2) / 2;
            if (media < 6.0) {
                resultado = false;
            }  else {
                resultado = true;
            }
        }
        return resultado;
    }

    public boolean verificaSeNotaEhInvalida (double n1, double n2) {
        boolean resultado;

        if (n1<0 || n2<0) {
            resultado = true;
        }
        else if (n1<0 || n2 > 0){
            resultado = true;
        }
        else if (n1>0 || n2 < 0) {
            resultado = true;
        }
        else {
            resultado = false;
        }

        return resultado;
    }


}
