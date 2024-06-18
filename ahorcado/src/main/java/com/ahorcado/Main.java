package com.ahorcado;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int intentos = 0;
        String[] palabras = {"zapato","correas","chaqueta","camisaseta"};
        // Generar un número entero aleatorio entre 0 y el tamaño del array 
        int numeroRandom = random.nextInt(palabras.length);
        System.out.println(numeroRandom);

        String palabraEscogida = palabras[numeroRandom];
        System.out.println(palabraEscogida);

       
            try (Scanner sc = new Scanner(System.in)) {
                while (intentos < 3) {
                    System.out.println("la palabra que debe adivinar tiene una longitud de "+ palabraEscogida.length()+ " Recuerde que si ingresa una palabra de mayor tamaño como respuesta, terminara el intento!");
                    System.out.println("Ingrese el primer intento");
                    String respuesta = sc.nextLine();
                    intentos++;
            }
        }
    }
}