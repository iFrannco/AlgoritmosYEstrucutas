package tp01.ejercicio2.ejercicios_1;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;

import java.util.Scanner;

public class TestListaDeEnterosConArreglos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazadaGenerica<Integer> numeros = new ListaEnlazadaGenerica<>();

        System.out.println("Ingrese un número para agregar a la lista (o 'fin' para terminar): ");

        while (true) {
            String entrada = sc.nextLine();
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }
            try {
                int numero = Integer.parseInt(entrada);
                numeros.agregarFinal(numero);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, intente de nuevo.");
            }
        }

        System.out.println("Elementos agregados a la lista: ");
        for (int i = 1; i <= numeros.tamanio(); i++) {
            System.out.println(numeros.elemento(i));
        }

        System.out.println("Imprimir en sentido inverso: ");
        OperacionesLista op = new OperacionesLista();
        op.imprimirSentidoInverso(numeros);


    }
}
