package com.adacorp.ma_bibliotheque.enums;

public enum EnumAbonnement {

    MENS(10000,"Mensuel"),
    TRIME(25000,"Trimestriel"),
    SEMES(50000,"Semestriel"),
    ANNUEL(100000,"Annuel");

    private String typeAbonnement;

    private int coutAbonement;

    EnumAbonnement(int coutAbonement, String typeAbonnement) {
        this.coutAbonement = coutAbonement;
        this.typeAbonnement = typeAbonnement;
    }
}
