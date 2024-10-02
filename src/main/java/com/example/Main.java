package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Este programa crea una baraja de cartas españolas.
 * 
 * Una carta tiene un número entre 1 y 12 (El 8 y el 9 no se incluyen) y un palo
 * (espadas, bastos, oros, y copas).
 * 
 * La baraja estará compuesta por un conjunto de cartas, 40 exactamente.
 * 
 * @author Jesús Gabriel Pollos Villazón
 * @author Alex Fan
 */
public class Main {
    public static ArrayList<Carta> baraja = new ArrayList<>();
    public static ArrayList<Carta> montonDeDescarte = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        rellenarBaraja();

        int opcion = -1;
        boolean salir = false;

        while (!salir) {
            // TODO: Quitar
            // mostrarBaraja(baraja, 5);
            System.out.println("\n*--------------------*");
            System.out.println("1) Barajar");
            System.out.println("2) Siguiente Carta");
            System.out.println("3) Cartas Disponibles");
            System.out.println("4) Dar Cartas");
            System.out.println("5) Cartas Monton");
            System.out.println("6) Mostrar Baraja");
            System.out.println("7) Salir");
            System.out.println("*--------------------*");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                // Barajar
                case 1:
                    barajar();
                    break;
                // Siguiente Carta
                case 2:
                    siguienteCarta();
                    break;
                // Cartas Disponibles
                case 3:
                    cartasDisponibles();
                    break;
                // Dar Cartas
                case 4:
                    darCartas();
                    break;
                // Cartas Monton
                case 5:
                    cartasMonton();
                    break;
                // Mostrar Baraja
                case 6:
                    mostrarBaraja(baraja, 5);
                    break;

                case 7:
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Cambia de posición todas las cartas aleatoriamente.
     */
    public static void barajar() {
        Collections.shuffle(baraja);
        System.out.println("Barajado!");
    }

    /*
     * Devuelve la siguiente carta que está en la baraja.
     * 
     * Cuando no haya más o se haya llegado al final, se indica al usuario que no
     * hay más cartas.
     */
    public static void siguienteCarta() {
        if (baraja.size() > 0) {
            Carta siguiente = baraja.get(0);
            baraja.remove(0);
            montonDeDescarte.add(siguiente);

            System.out.println("La siguiente carta es: " + siguiente);
        } else {
            System.out.println("No quedan cartas :(");
        }
    }

    /**
     * Indica el número de cartas que aún puede repartir.
     */
    public static void cartasDisponibles() {
        System.out.println("Quedan " + baraja.size() + " cartas.");
    }

    /**
     * Dado un número de cartas que nos pidan, le devolveremos ese número de cartas.
     * 
     * En caso de que haya menos cartas que las pedidas, no devolvremos nada, pero
     * debemos indicárselo al usuario.
     */
    public static void darCartas() {
        try {
            System.out.println("Cartas que quieres: ");
            int numCartas = scanner.nextInt();
            // scanner.next(); // Flush

            if (baraja.size() > 0) {
                if (numCartas <= baraja.size()) {

                    for (int i = 0; i < numCartas; i++) {
                        Carta siguiente1 = baraja.get(0);
                        baraja.remove(0);
                        montonDeDescarte.add(siguiente1);
                        System.out.println(siguiente1);
                    }
                } else {
                    System.out.println(
                            "El número: " + numCartas + " es más grande que la baraja que queda: " + baraja.size());
                }
            } else {
                System.out.println("No quedan cartas :(");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error, Tienes que introducir un número entero válido");
        }
    }

    /**
     * Mostramos aquellas cartas que ya han salido.
     * 
     * Si no ha salido ninguna indicárselo al usuario.
     */
    public static void cartasMonton() {
        mostrarBaraja(montonDeDescarte, 5);
    }

    /**
     * Muestra todas las cartas hasta el final.
     * 
     * Es decir, si se saca una carta y luego se llama al método, este no mostrara
     * esa primera carta.
     */
    public static void mostrarBaraja(ArrayList<Carta> laBaraja, int separador) {
        System.out.println("\n*-------------- Estado de baraja ---------------*");
        if (laBaraja.size() <= 0) {
            System.out.println("No hay cartas");
        } else {
            for (int i = 0; i < laBaraja.size(); i++) {
                if (i != 0 && separador != 0 && i % separador == 0) {
                    System.out.println();
                }
                System.out.print("[" + laBaraja.get(i).getNumero() + ", " + Carta.Palo.values()[laBaraja.get(i).getPalo()] + "] ");

            }
        }
        System.out.println("\n*-----------------------------------------------*");
    }

    /**
     * Rellena la baraja sin random.
     */
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