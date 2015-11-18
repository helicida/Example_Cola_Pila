package Pila;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by mireia on 14/11/2015.
 */
public class Pila <E>{

    private final int tope;
    private int longitud = -1;
    private E[] arrayPila;

    public Pila(E[]array) {  // Constructor

        arrayPila = array;  // El array de la pila será igual al array introducido
        tope = array.length; // tope es la cantidad de que caben en el array

        for (int iterador = 0; iterador < array.length; iterador++) {
            if (array[iterador] != null) {
                longitud = iterador;    // la longitud será igual a la ultima posición del array que no sea null
            }
        }
    }


    public void add( E value ) throws ExcepcionLlena{

        if ( longitud == tope - 1 ){  // Si el longitud es igual a la tope menos uno y se intenta añadir algún numero, tendremos exepcion
            throw new ExcepcionLlena("La Pila esta llena");  // si la pila está llena
        }
        arrayPila[++longitud] = value; // coloca valorAMeter en la Pila
    }


    public E get() throws ExcepcionVacia {

        if ( longitud == -1 ) { // si la pila está vacía
            throw new ExcepcionVacia("La Pila esta vacia");
        }
        return arrayPila[longitud--]; // elimina y devuelve el elemento superior de la Pila
    }

    public <E extends Comparable <E>> E getMax () throws ExcepcionVacia{

        if(longitud == -1){ // Si el longitud es -1 es que la pila está vacía
            throw new ExcepcionVacia( "La Pila esta vacia");
        }

        E numMax = (E) arrayPila[longitud];
        for(int iterador = 0; iterador <= longitud; iterador++){
            if(numMax.compareTo((E)(arrayPila[iterador]))<0){
                numMax=(E)(arrayPila[iterador]);
            }
        }
        return numMax;
    }

    public <E extends Comparable <E>> E getMin () throws ExcepcionVacia{

        if(longitud == -1){  // Si el longitud es -1 es que la pila está vacía
            throw new ExcepcionVacia( "La Pila esta vacia");
        }
        E numMin= (E) arrayPila[longitud];

        for(int iterador = 0; iterador <= longitud; iterador++){
            if(numMin.compareTo((E)(arrayPila[iterador])) > 0){
                numMin=(E)(arrayPila[iterador]);
            }
        }
        return numMin;
    }

    public int getNumPos(E value)throws ExcepcionVacia{

        if(longitud == -1){  // Si el longitud es -1 es que la pila está vacía
            throw new ExcepcionVacia( "La Pila esta vacia" );
        }

        for(int iterador = 0; iterador <= longitud; iterador++){
            if(value.equals(arrayPila[iterador])){  //cuando el valor coincide con el del array entonces
                return iterador;  // devolvemos el iterador que es la posición de tal numero
            }
        }
        return -1;  // En caso de no existir ese numero, devuelve -1
    }
}
