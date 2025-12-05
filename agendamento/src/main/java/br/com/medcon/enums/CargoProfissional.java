package br.com.medcon.enums;

public enum CargoProfissional {
    MEDICO(0), 
    ENFERMEIRO(1), 
    TECNICO(2);

    private final int codigo;

    CargoProfissional(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static CargoProfissional fromCodigo(int codigo) {
        for (CargoProfissional cargoProfissional : values()) {
            if(cargoProfissional.getCodigo() == codigo) {
                return cargoProfissional;
            }
        }
        throw new IllegalArgumentException("O Valor é invalido: " + codigo);
    }
}
