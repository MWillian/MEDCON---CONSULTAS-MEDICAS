package br.com.medcon.enums;

public enum StatusSolicitacao {
    AGENDADA(0), PENDENTE(1), CANCELADA(2);

    private final int codigo;

    StatusSolicitacao(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public static StatusSolicitacao fromCodigo(int codigo) {
        for (StatusSolicitacao statusSolicitacao : values()) {
            if(statusSolicitacao.getCodigo() == codigo) {
                return statusSolicitacao;
            }
        }
        throw new IllegalArgumentException("O Valor invalido: " + codigo);
    }
}
