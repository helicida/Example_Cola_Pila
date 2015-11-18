package Pila;

/**
 * Created by mireia on 18/11/2015.
 */
public class Main {

    public static void main(String[] args) throws ExcepcionLlena, ExcepcionVacia {

        Integer arrayPila[] = {5, 4, 2, 41, 87, 45, 58, 452, 7};    // Array con los numeros de la pila
        Integer numRandom;  // Numero que usaremos para llenar la pila de numeros aleatorios

        Pila pila1 = new Pila(arrayPila); // Creamos un nuevo objeto pila

        System.out.println("Pila en su estado inicial:");

        for (int iterador = 0; iterador < 9; iterador++) {
            System.out.print(" | " +  arrayPila[iterador] + " ");
        }

        System.out.println("\n");
        System.out.println("Max: " + pila1.getMax());
        System.out.println("Min:  " + pila1.getMin());
        System.out.println("Posicion del entero 7: " + pila1.getNumPos(7));

        System.out.println(" ---------------------------------------------------------------------- \n");

        System.out.println("Desapilamos todos los elemtos de la pila: ");

        for (int iterador = 0; iterador < 9; iterador++) {
            System.out.print(" | " + pila1.get() + " ");
        }

        System.out.println();

        System.out.println("\nApilamos mas numeros al arrayPila: ");

        for (int iterador = 0; iterador < 9; iterador++) {
            numRandom = (int) ((Math.random()) * 99 + 1);
            System.out.print(" | " + numRandom + " ");
            pila1.add(numRandom);
        }

        System.out.println();
        System.out.println("\nMax: " + pila1.getMax());
        System.out.println("Min: " + pila1.getMin());

        System.out.print("Posicion del entero 15 en la pila: ");

        if(pila1.getNumPos(15) == -1){  // Usamos un if para comprobar si el numero existe y mostrar el mensaje correspondiente
            System.out.print(" No se encuentra en la pila");
        }
        else{
            System.out.print(pila1.getNumPos(15));  // Mostramos la posicion del numero en la pila
        }

        System.out.println();
        System.out.println("\nFinal del programa");
    }
}