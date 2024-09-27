package com.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<Carta> baraja = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        rellenarBaraja();

        for (Carta carta : baraja) {
            System.out.println(carta);
        }

        int opcion = -1;
        boolean valido = false;
        boolean salir = false;

        while (!salir) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.println(1);
                    break;

                case 5:
                    salir = true;
                    break;
                default:
                    break;
            }
        }

        // switch (args) {
        // case value:

        // break;

        // default:
        // break;
        // }

    }

    // TODO: terminar
    public static void barajar() {
        Random random = new Random();
        int randomNumber = random.nextInt(baraja.size());
        // int posicionCarta = (randomNumber.get(numero.size) - 1);

    }

    // TODO: terminar
    // public static Carta siguienteCarta() {

    // }

    // TODO: terminar
    // public static int cartasDisponibles() {

    // }

    // TODO: terminar
    // public static ArrayList<Carta> darCartas() {

    // }

    // TODO: terminar
    public static void cartasMonton() {

    }

    // TODO: terminar
    public static void mostrarBaraja() {

    }

    // Hecho
    public static void rellenarBaraja() {
        for (int i = 1; i <= 12; i++) {
            if (i == 8 || i == 9) {
                continue;
            }

            for (int j = 0; j < Carta.Palo.values().length; j++) {
                Carta newCarta = new Carta(i, j);
                baraja.add(newCarta);
            }
        }

    }
}