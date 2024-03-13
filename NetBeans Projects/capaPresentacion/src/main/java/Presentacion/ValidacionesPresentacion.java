/*
 * ValidacionesPresentacion.java
 */
package Presentacion;

/**
 *
 * @author Juventino López García - 00000248547 - 11/03/2024
 */
public class ValidacionesPresentacion {

    public static void edadValida(String edad) throws PresentacionException {
        try {
            if (Integer.parseInt(edad) < 18) 
                throw new PresentacionException("La edad debe ser mayor a 18 años");
        } catch (NumberFormatException ne) {
            throw new PresentacionException("La edad debe ser un numero");
        } catch (PresentacionException pe) {
            throw pe;
        }
    }

    public static void idValida(String id) throws PresentacionException {
        try {
            if (Long.parseLong(id) <= 0) {
                throw new PresentacionException("El id debe ser mayor a 0");
            }
        } catch (NumberFormatException ne) {
            throw new PresentacionException("El id debe ser un numero");
        } catch (PresentacionException pe) {
            throw pe;
        }
    }
}
