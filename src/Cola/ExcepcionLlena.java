package Cola;

/**
 * Created by 46465442z on 30/10/15.
 */
class ExcepcionLlena extends Exception {

    public ExcepcionLlena(String mensage) {
        super(mensage); // Devuelve la excepción que el mensaje que le introducimos desde el main
    }
}