package Cola;

import java.text.DecimalFormat;

/**
 * Created by sergi on 18/11/15.
 */
public class Main {

    public static void main(String[] args) throws ExcepcionVacia, ExcepcionLlena {

        // Variables y arrays

        Double arrayNum[] = {15.32, 5.6, 98.4, 2.5, 36.1, 2.2, 6.43, 34.53, 2.35, 2.0, 43.2, 32.03, 234.1, 23.4, 12.5};
        Double numRandom = 0.1;   // Variable que usaremos para generar un numero al azar
        DecimalFormat nomenclaturaDecimal = new DecimalFormat("#0.00"); // Esto es necesario porque si no se generan numeros con muchos decimales. ej: 3.106222681598217

        Cola cola = new Cola(arrayNum);    // Creamos un nuevo objeto de tipo cola

        // Mostramos la cola

        System.out.println("Nuestra cola es: ");

        for(int iterador = 0; iterador < arrayNum.length; iterador++){
            System.out.print(" | " + nomenclaturaDecimal.format(arrayNum[iterador]) + " ");
        }

        // Estadisticas de la cola al azar

        System.out.println();
        System.out.println(" \n Max: " + cola.getMax());
        System.out.println(" Min: " + cola.getMin());
        System.out.println(" Posición del número 15.32: " + cola.getNumPos(15.32));
        System.out.println(" Posición del número 34.53: " + cola.getNumPos(34.53));

        System.out.println("\n ---------------------------------------------------------------------- \n");

        System.out.println("Eliminamos los diez primeros numeros:");

        // Mostramos los numeros que se eliminan a través de un for

        for(int iterador = 0; iterador < 10; iterador++){
            System.out.print(" | " + nomenclaturaDecimal.format(cola.get()) + " ");
        }

        System.out.println();
        System.out.println(" \n Max :" + cola.getMax());
        System.out.println(" Min :" + cola.getMin());
        System.out.println(" Posición del número 43.2: " + cola.getNumPos(43.2));
        System.out.println(" Posición del número 32.03: " + cola.getNumPos(32.03));

        System.out.println("\n ---------------------------------------------------------------------- \n");

        System.out.println("Introducimos diez numeros en los huevos que hemos dejado libres ");

        // Rellenamos las diez últimas posiciones con un for de numeros aleatorios

        for(int iterador = 0; iterador < 10; iterador++){
            numRandom = (Double)((Math.random())*99+1);
            System.out.print(" | " + nomenclaturaDecimal.format(numRandom)  + " ");
            cola.añadirNum(numRandom);
        }

        // Estadisticas después de jugar con la cola

        System.out.println();
        System.out.println("\n Max :" + cola.getMax());
        System.out.println(" Min :" + cola.getMin());
        System.out.println(" Posición del número 234.1: " + cola.getNumPos(234.1));
        System.out.println(" Posición del número 12.5:  " + cola.getNumPos(12.5));

        System.out.println("\n ---------------------------------------------------------------------- \n");

        System.out.println("Vaciamos la cola y la imprimimos en pantalla: ");

        for(int iterador = 0; iterador < 15; iterador ++){
            System.out.print(" | " + nomenclaturaDecimal.format(cola.get()) + " " );
        }

        System.out.println();
        System.out.println("\nComo se puede ver, vamos retirando números por la izquierda y van entrando por la derecha, que es como ha de funcionar una cola.");
        System.out.println("\n Fin del programa");
    }
}
