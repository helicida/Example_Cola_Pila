package Cola;

/**
 * Created by 46465442z on 30/10/15.
 */
public class Cola <E> {

    private int longitudCola;   // cómo de larga será la cola
    private int inicioCola = 0; // inicio de la cola
    private int finCola = -1;    // fin de la cola
    private E[] arrayCola;      // Array de nuestro objeto

    public Cola(E [] arr) {     // Constructor del tipo Cola.

        longitudCola = arr.length; // Ajusta la longitud de la cola al tamñao del array que tenga
        arrayCola = arr; // El array introducido será igual a nuestro array

        //Recorre todos los numeros de la cola para saber donde está el finCola de la misma

        for(int iterador = 0; iterador < arr.length; iterador++){
            if(arr[iterador]!=null){
                finCola = iterador;
            }
        }
    }

    // Método para añadir números

    public void añadirNum(E numero) throws ExcepcionLlena{ // Al añadir un numero podemos recibir una excepción concorde que la cola está llena

        if(finCola < inicioCola + longitudCola) {
            arrayCola[++finCola % longitudCola] = numero;
        }
        else{
            throw new ExcepcionLlena("La cola esta llena, no se puede añadir ningún número más.");
        }
    }

    // Método para retirar números

    public E get() throws ExcepcionVacia {  // A la hora de extraer numeros podemos recibir una excepción de cola vacía

        if(inicioCola <= finCola){  // Si la cola tiene algo dentro (es decir, el inicio es mas pequeño que el fin)
            if(inicioCola == longitudCola){
                inicioCola = 0;
                finCola -= longitudCola;
                return arrayCola[inicioCola++];
            }
            else if(inicioCola == -1 && finCola >= 0){
                inicioCola = 0;
            }
            return arrayCola[inicioCola++ % longitudCola];
        }
        else {
            throw new ExcepcionVacia("La cola esta vacia"); // Si no se cumple la anterior condición, es que está vacía así que hacemos saltar la excepción
        }
    }

    // Metodo para saber la posición dentro del array de un numero determinado

    public int getNumPos(E num) throws ExcepcionVacia {

        if(finCola == -1 || longitudCola == 0){   // Comprobamos si la cola está vacía, si lo está devolvemos la correspondiente excepción
            throw new ExcepcionVacia("La cola esta vacia.");
        }
        else{
            for(int iterador = inicioCola; iterador <= finCola; iterador++){
                if(num.equals(arrayCola[iterador])){
                    return iterador;
                }
            }
        }
        return -1;
    }

    // Metodo que usaremos para conocer el máximo

    public <E extends Comparable<E>> E getMax() throws ExcepcionVacia {

        if(finCola ==-1 || longitudCola == 0){      // Comprobamos si la cola está vacía, si lo está devolvemos la correspondiente excepción
            throw new ExcepcionVacia("La cola esta vacia.");
        }

        E numMax = (E)arrayCola[inicioCola];

        for(int iterador = inicioCola; iterador < longitudCola;iterador++){
            if(numMax.compareTo((E)(arrayCola[iterador])) < 0){
                numMax = (E)arrayCola[iterador];
            }
        }
        return numMax;
    }

    // Metodo que usaremos para conocer el mínimo

    public <E extends Comparable<E>> E getMin() throws ExcepcionVacia {

        if(finCola ==-1 || longitudCola == 0){   // Comprobamos si la cola está vacía, si lo está devolvemos la correspondiente excepción
            throw new ExcepcionVacia("La cola esta vacia.");
        }

        E numMin = (E)arrayCola[inicioCola];

        for(int iterador = inicioCola; iterador < longitudCola;iterador++){
            if(numMin.compareTo((E)(arrayCola[iterador])) > 0){
                numMin = (E)arrayCola[iterador];
            }
        }
        return numMin;
    }
}

