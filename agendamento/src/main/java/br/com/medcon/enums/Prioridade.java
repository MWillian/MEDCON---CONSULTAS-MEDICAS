package br.com.medcon.enums;

public enum Prioridade {
    NORMAL(0),IDOSO(1),GESTANTE(2);

    private final int codigo;

    Prioridade(int codigo) {
       this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Prioridade fromCodigo(int codigo) {
        for (Prioridade prioridade : values()) {
            if(prioridade.getCodigo() == codigo) {
                return prioridade;
            }
        }
        throw new IllegalArgumentException("O Valor invalido: " + codigo);
    }
}
