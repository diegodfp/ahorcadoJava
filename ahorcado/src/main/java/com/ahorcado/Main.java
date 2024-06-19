package com.ahorcado;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int intentos = 0;
        String[] palabras = {"zapato", "correas", "chaqueta", "camisaseta"};
        int numeroRandom = random.nextInt(palabras.length);

        String palabraEscogida = palabras[numeroRandom];

        // Convertir la palabra escogida en un ArrayList de caracteres
        ArrayList<Character> letras = new ArrayList<>();
        for (char letra : palabraEscogida.toCharArray()) {
            letras.add(letra);
        }

        // Crear un ArrayList para almacenar las letras adivinadas
        ArrayList<Character> letrasAdivinadas = new ArrayList<>();
        for (int i = 0; i < palabraEscogida.length(); i++) {
            letrasAdivinadas.add('_');
        }

        try (Scanner sc = new Scanner(System.in)) {
            boolean juegoTerminado = false;

            while (intentos < 6 && letrasAdivinadas.contains('_') && !juegoTerminado) {
                System.out.println("La palabra que debe adivinar tiene una longitud de " + palabraEscogida.length());
                System.out.print("Palabra: ");
                for (char c : letrasAdivinadas) {
                    System.out.print(c + " ");
                }
                System.out.println("\nIngrese '1' para intentar adivinar la palabra completa, '2' para intentar adivinar una letra, o '3' para salir:");

                String opcion = sc.nextLine();

                switch (opcion) {
                    case "1":
                        System.out.println("Ingrese su intento para adivinar la palabra completa:");
                        String intentoPalabra = sc.nextLine();
                        if (intentoPalabra.equals(palabraEscogida)) {
                            System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraEscogida);
                            juegoTerminado = true;
                        } else {
                            intentos++;
                            System.out.println("Intento incorrecto. Te quedan " + (6 - intentos) + " intentos.");
                        }
                        break;
                    case "2":
                        System.out.println("Ingrese una letra:");
                        String intentoLetra = sc.nextLine();
                        if (intentoLetra.length() != 1) {
                            intentos++;
                            System.out.println("Debe ingresar solo una letra. Te quedan " + (6 - intentos) + " intentos.");
                        } else {
                            char respuesta = intentoLetra.charAt(0);
                            if (letras.contains(respuesta)) {
                                for (int i = 0; i < letras.size(); i++) {
                                    if (letras.get(i) == respuesta) {
                                        letrasAdivinadas.set(i, respuesta);
                                    }
                                }
                            } else {
                                intentos++;
                                System.out.println("Letra incorrecta. Te quedan " + (6 - intentos) + " intentos.");
                            }
                        }
                        break;
                    case "3":
                        System.out.println("Has salido del juego.");
                        juegoTerminado = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            }

            if (!letrasAdivinadas.contains('_') && !juegoTerminado) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraEscogida);
            } else if (intentos >= 6) {
                System.out.println("Lo siento, has perdido. La palabra era: " + palabraEscogida);
            }
        }
    }
}
