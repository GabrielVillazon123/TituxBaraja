package com.example;

public class Carta {
    // public final int PALO_ESPADAS = 1;
    // public final int PALO_BASTOS = 2;
    // public final int PALO_OROS = 3;
    // public final int PALO_COPAS = 4;

    public enum Palo {
        Espada,
        Basto,
        Oro,
        Copa
    }

    private int numero;
    private int palo;

    public Carta(int numero, int palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public int getPalo() {
        return palo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPalo(int palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "Carta [numero=" + numero + ", palo=" + palo + "]";
    }
}