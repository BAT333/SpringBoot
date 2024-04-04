package com.rafael.demo.persistenciaJava.model;

public enum VehicleType {
    PASSAGEIRO(1),
    CARGA(2),
    MISTO(3),
    SLA(4),
    TRACAO(5),
    ESPECIAL(6);

    private int valor;
    VehicleType(int values){
        this.valor = values;
    }

    public int getValor() {
        return valor;
    }


    public static VehicleType Type(int valeus) {
        return switch (valeus) {
            case 1 -> VehicleType.PASSAGEIRO;
            case 2 -> VehicleType.CARGA;
            case 3 -> VehicleType.MISTO;
            case 4 -> VehicleType.SLA;
            case 5 -> VehicleType.TRACAO;
            case 6 -> VehicleType.ESPECIAL;
            default -> throw new RuntimeException("NUMERO INVALIDO");
        };
    }
}
