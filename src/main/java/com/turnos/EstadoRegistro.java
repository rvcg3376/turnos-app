package com.turnos;

public enum EstadoRegistro {
    ACTIVO(1),
    ANULADO(2),
    FINALIZADO(3);

    private final int codigo;

    EstadoRegistro(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static EstadoRegistro fromCodigo(int codigo) {
        for (EstadoRegistro e : values()) {
            if (e.codigo == codigo) {
                return e;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }

}
